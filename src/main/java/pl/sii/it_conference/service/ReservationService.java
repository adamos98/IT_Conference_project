package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.dto.ReservationWithIdDto;
import pl.sii.it_conference.dto.UserDto;

import java.util.List;

public interface ReservationService {

    ReservationWithIdDto addNewReservation(UserDto userDto, Long prelectionId);

    Long deleteReservation(Long reservationId);

    List<ReservationDto> getAllReservations();

    List<ReservationWithIdDto> showReservationsByLogin(String login);

}
