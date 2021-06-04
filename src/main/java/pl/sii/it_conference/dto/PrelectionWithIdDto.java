package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PrelectionWithIdDto {
    private Long id;
    private String subjectOfPrelection;
    private TimeOfPrelectionDto timeOfPrelection;
    private Long amountOfUsers;
}
