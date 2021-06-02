package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.dto.ReservationVO;
import pl.sii.it_conference.dto.UserDto;

import java.util.List;

public interface ReservationService {

    ReservationVO addNewReservation(UserDto userDto, Long prelectionId);

    Long deleteReservation(Long reservationId);

    List<ReservationDto> getAllReservations();

    List<ReservationVO> showReservationsByLogin(String login);

}
