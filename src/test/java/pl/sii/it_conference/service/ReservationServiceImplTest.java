package pl.sii.it_conference.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import pl.sii.it_conference.dto.*;
import pl.sii.it_conference.entity.Prelection;
import pl.sii.it_conference.entity.Reservation;
import pl.sii.it_conference.entity.TimeOfPrelection;
import pl.sii.it_conference.entity.User;
import pl.sii.it_conference.repository.PrelectionRepository;
import pl.sii.it_conference.repository.ReservationRepository;
import pl.sii.it_conference.repository.UserRepository;
import pl.sii.it_conference.serviceImplementation.PrelectionServiceImpl;
import pl.sii.it_conference.serviceImplementation.ReservationServiceImpl;
import pl.sii.it_conference.serviceImplementation.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ReservationServiceImplTest {

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private PrelectionServiceImpl prelectionService;

    @Mock
    private PrelectionRepository prelectionRepository;

    @Mock
    private UserRepository userRepository;


    Reservation reservation = Reservation.builder()
            .id(1L)
            .user(new User())
            .prelection(new Prelection())
            .build();

    ReservationDto reservationDto = ReservationDto.builder()
            .prelection(new PrelectionWithIdDto())
            .user(new UserWithIdDto())
            .build();

    PrelectionDto prelectionDto = PrelectionDto.builder()
            .amountOfUsers(0L)
            .subjectOfPrelection("test")
            .timeOfPrelection(new TimeOfPrelectionDto())
            .build();

    ReservationWithIdDto reservationWithIdDto = ReservationWithIdDto.builder()
            .id(1L)
            .user(new UserDto())
            .prelection(prelectionDto)
            .build();

    Prelection prelection = Prelection.builder()
            .id(0L)
            .amountOfUsers(0L)
            .timeOfPrelection(new TimeOfPrelection())
            .subjectOfPrelection("test")
            .build();

    @Test
    void addNewReservation() {
        when(reservationRepository.findById(reservation.getId())).thenReturn(Optional.of(reservation));
        when(modelMapper.map(reservationDto,Reservation.class)).thenReturn(reservation);
        when(prelectionRepository.findById(anyLong())).thenReturn(Optional.of(prelection));
    }


    @Test
    void getAllReservations() {
        when(reservationRepository.findAll()).thenReturn(List.of(reservation));
        when(reservationService.getAllReservations()).thenReturn(List.of(reservationDto));
        assertEquals(List.of(reservationDto),reservationService.getAllReservations());
        verify(reservationRepository,times(2)).findAll();
    }

    @Test
    void showReservationsByLogin() {
        when(reservationRepository.findAllByUser_Login(anyString())).thenReturn(List.of(reservation));
        when(reservationService.showReservationsByLogin(anyString())).thenReturn(List.of(reservationWithIdDto));
        assertEquals(List.of(reservationWithIdDto),reservationService.showReservationsByLogin(anyString()));
        verify(reservationRepository,times(2)).findAllByUser_Login(anyString());
    }
}
