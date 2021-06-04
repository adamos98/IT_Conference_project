package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class PrelectionDto {
    private String subjectOfPrelection;
    private TimeOfPrelectionDto timeOfPrelection;
    private Long amountOfUsers;
}
