package pl.sii.it_conference.dto;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class TimeOfPrelectionDto {
    private Time startOfPrelection;
    private Time endOfPrelection;
}
