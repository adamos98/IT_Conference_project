package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.PrelectionWithIdDto;
import pl.sii.it_conference.entity.Prelection;

@Component
public class PrelectionVOMapper extends AbstractConverter<Prelection, PrelectionWithIdDto> {

    @Override
    protected PrelectionWithIdDto convert(Prelection prelection) {
        return PrelectionWithIdDto.builder()
                .id(prelection.getId())
                .subjectOfPrelection(prelection.getSubjectOfPrelection())
                .timeOfPrelection(prelection.getTimeOfPrelection())
                .amountOfUsers(prelection.getAmountOfUsers())
                .build();
    }
}
