package pl.sii.it_conference.serviceImplementation;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.sii.it_conference.constant.ErrorMessage;
import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.dto.ReservationVO;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.entity.Prelection;
import pl.sii.it_conference.entity.Reservation;
import pl.sii.it_conference.entity.User;
import pl.sii.it_conference.exceptions.FullPrelectionException;
import pl.sii.it_conference.exceptions.NotDeletedException;
import pl.sii.it_conference.exceptions.NotFoundException;
import pl.sii.it_conference.exceptions.UserAlreadyReservedPrelectionOnThatTimeException;
import pl.sii.it_conference.repository.PrelectionRepository;
import pl.sii.it_conference.repository.ReservationRepository;
import pl.sii.it_conference.repository.UserRepository;
import pl.sii.it_conference.service.PrelectionService;
import pl.sii.it_conference.service.ReservationService;
import pl.sii.it_conference.service.UserService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final PrelectionRepository prelectionRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PrelectionService prelectionService;
    private final ModelMapper modelMapper;

    @Override
    public ReservationVO addNewReservation(UserDto userDto, Long prelectionId) {
        Reservation reservation = modelMapper.map(new ReservationDto(),Reservation.class);
        Prelection prelection = prelectionRepository.findById(prelectionId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.PRELECTION_NOT_FOUND_BY_ID + prelectionId));
        if(!prelectionService.checkIfPrelectionIsNotFull(prelection)){
            throw new FullPrelectionException(ErrorMessage.PRELECTION_IS_FULL);
        }
        userService.save(userDto);
        if(checkIfUserHasNoReservationOnTheSameTime(prelectionId,userDto)){
            throw new UserAlreadyReservedPrelectionOnThatTimeException(ErrorMessage.USER_RESERVED_ON_THAT_TIME);
        }
        User user = userRepository.findByLogin(userDto.getLogin()).orElseThrow(()->
                new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_LOGIN + userDto.getLogin()));
        reservation.setUser(user);
        reservation.setPrelection(prelection);
        Reservation created = reservationRepository.save(reservation);
        prelectionService.addUserToPrelection(prelectionId);
        try {
            saveEmailAsFile(userDto,prelectionId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelMapper.map(created,ReservationVO.class);
    }

    @Override
    public Long deleteReservation(Long reservationId) {
        Reservation reservation;
        reservation = reservationRepository.findById(reservationId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.RESERVATION_NOT_FOUND_WITH_ID + reservationId));
        reservation.getPrelection().setAmountOfUsers(reservation.getPrelection().getAmountOfUsers()-1);
        try{
            reservationRepository.deleteById(reservationId);
        }catch (EmptyResultDataAccessException ex){
            throw new NotDeletedException(ErrorMessage.RESERVATION_NOT_DELETED);
        }
        return reservationId;
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return modelMapper.map(reservationRepository.findAll(), new TypeToken<List<ReservationDto>>() {
        }.getType());
    }

    @Override
    public List<ReservationVO> showReservationsByLogin(String login) {
        return modelMapper.map(reservationRepository.findAllByUser_Login(login), new TypeToken<List<ReservationVO>>(){
        }.getType());
    }

    public boolean checkIfUserHasNoReservationOnTheSameTime(Long prelectionId,UserDto userDto){
        Prelection prelection = prelectionRepository.findById(prelectionId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.PRELECTION_NOT_FOUND_BY_ID + prelectionId));
        User user = userRepository.findByLogin(userDto.getLogin()).orElseThrow(()->
                new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_LOGIN + userDto.getLogin()));
        List<ReservationDto>  listOfReservations = getAllReservations();
        boolean flag = false;
        for(ReservationDto reservation : listOfReservations){
            flag = reservation.getUser().getId().equals(user.getId())
                    && reservation.getPrelection().getTimeOfPrelection().equals(prelection.getTimeOfPrelection());
            if(flag)
                break;
        }
        return flag;
    }

    public void saveEmailAsFile(UserDto userDto, Long prelectionId) throws IOException {
        Prelection prelection = prelectionRepository.findById(prelectionId).orElseThrow(() ->
                new NotFoundException(ErrorMessage.PRELECTION_NOT_FOUND_BY_ID + prelectionId));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        FileWriter fileWriter = new FileWriter("email.txt",true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("-----NOWY EMAIL-----\nData wysłania: " + formatter.format(new Date()) + "\nDo: "
                + userDto.getEmail() + ", " + userDto.getLogin() + "\nUdało Ci się zapisać na prelekcje! \nTemat: "
                + prelection.getSubjectOfPrelection() + "\nW godzinach: " + prelection.getTimeOfPrelection().getStartOfPrelection() + " - "
                + prelection.getTimeOfPrelection().getEndOfPrelection() + "\nSerdecznie zapraszamy!\n-------------------\n");
        printWriter.close();
    }
}
