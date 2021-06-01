package pl.sii.it_conference.dto;

import lombok.*;
import pl.sii.it_conference.entity.Prelection;
import pl.sii.it_conference.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDto {
    private User user;
    private Prelection prelection;
}
