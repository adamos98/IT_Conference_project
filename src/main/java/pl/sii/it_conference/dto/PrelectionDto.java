package pl.sii.it_conference.dto;

import lombok.*;
import pl.sii.it_conference.entity.TimeOfPrelection;

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
