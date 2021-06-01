package pl.sii.it_conference.dto;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationVO {
    private Long id;
    private UserDto user;
    private PrelectionDto prelection;
}
