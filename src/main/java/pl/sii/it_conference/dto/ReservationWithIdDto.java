package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationWithIdDto {
    private Long id;
    private UserDto user;
    private PrelectionDto prelection;
}
