package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.PrelectionVO;
import pl.sii.it_conference.entity.Prelection;

@Component
public class PrelectionVOMapper extends AbstractConverter<PrelectionVO, Prelection> {
    @Override
    protected Prelection convert(PrelectionVO prelectionVO) {
        return Prelection.builder()
                .timeOfPrelection(prelectionVO.getTimeOfPrelection())
                .subjectOfPrelection(prelectionVO.getSubjectOfPrelection())
                .amountOfUsers(prelectionVO.getAmountOfUsers())
                .id(prelectionVO.getId())
                .build();
    }
}
