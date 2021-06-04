package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDto {
    private UserWithIdDto user;
    private PrelectionWithIdDto prelection;
}
