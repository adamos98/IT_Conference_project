package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.PrelectionDto;
import pl.sii.it_conference.entity.Prelection;


@Component
public class PrelectionDtoMapper extends AbstractConverter<PrelectionDto, Prelection> {

    @Override
    protected Prelection convert(PrelectionDto prelectionDto) {
        return Prelection.builder()
                .subjectOfPrelection(prelectionDto.getSubjectOfPrelection())
                .timeOfPrelection(prelectionDto.getTimeOfPrelection())
                .amountOfUsers(prelectionDto.getAmountOfUsers())
                .build();
    }
}
