package pl.sii.it_conference.serviceImplementation;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import pl.sii.it_conference.constant.ErrorMessage;
import pl.sii.it_conference.dto.PrelectionDto;
import pl.sii.it_conference.dto.PrelectionWithIdDto;
import pl.sii.it_conference.entity.Prelection;
import pl.sii.it_conference.exceptions.NotFoundException;
import pl.sii.it_conference.repository.PrelectionRepository;
import pl.sii.it_conference.service.PrelectionService;

import java.util.List;

@Service
@AllArgsConstructor
public class PrelectionServiceImpl implements PrelectionService {
    private final PrelectionRepository prelectionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PrelectionWithIdDto> getAllPrelections() {
        return modelMapper.map(prelectionRepository.findAll(),new TypeToken<List<PrelectionWithIdDto>>(){
        }.getType());
    }

    @Override
    public PrelectionDto addUserToPrelection(Long id) {
        Prelection prelection = prelectionRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorMessage.PRELECTION_NOT_FOUND_BY_ID + id));
        prelection.setAmountOfUsers(prelection.getAmountOfUsers()+1);
        Prelection updated = prelectionRepository.save(prelection);

        return modelMapper.map(updated,PrelectionDto.class);
    }

    public boolean checkIfPrelectionIsNotFull(Prelection prelection){
        return prelection.getAmountOfUsers() != 5;
    }
}
