package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.entity.Reservation;

@Component
public class ReservationDtoMapper extends AbstractConverter<Reservation, ReservationDto> {

    @Override
    protected ReservationDto convert(Reservation reservation) {
        return ReservationDto.builder()
                .user(reservation.getUser())
                .prelection(reservation.getPrelection())
                .build();
    }
}
