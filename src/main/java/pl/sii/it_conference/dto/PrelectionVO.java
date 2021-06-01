package pl.sii.it_conference.dto;

import lombok.*;
import pl.sii.it_conference.entity.TimeOfPrelection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PrelectionVO {
    private Long id;
    private String subjectOfPrelection;
    private TimeOfPrelection timeOfPrelection;
    private Long amountOfUsers;
}
