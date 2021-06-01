package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.PrelectionDto;
import pl.sii.it_conference.entity.Prelection;


@Component
public class PrelectionDtoMapper extends AbstractConverter<Prelection, PrelectionDto> {

    @Override
    protected PrelectionDto convert(Prelection prelection) {
        return PrelectionDto.builder()
                .subjectOfPrelection(prelection.getSubjectOfPrelection())
                .timeOfPrelection(prelection.getTimeOfPrelection())
                .amountOfUsers(prelection.getAmountOfUsers())
                .build();
    }
}
