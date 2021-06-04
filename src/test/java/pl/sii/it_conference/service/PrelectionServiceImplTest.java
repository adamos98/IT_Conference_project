package pl.sii.it_conference.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import pl.sii.it_conference.dto.PrelectionDto;
import pl.sii.it_conference.dto.PrelectionWithIdDto;
import pl.sii.it_conference.dto.TimeOfPrelectionDto;
import pl.sii.it_conference.entity.Prelection;
import pl.sii.it_conference.entity.TimeOfPrelection;
import pl.sii.it_conference.repository.PrelectionRepository;
import pl.sii.it_conference.serviceImplementation.PrelectionServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PrelectionServiceImplTest {

    @Mock
    PrelectionRepository prelectionRepository;

    @InjectMocks
    private PrelectionServiceImpl prelectionService;

    @Mock
    private ModelMapper modelMapper;

    Prelection prelection = Prelection.builder()
            .id(1L)
            .subjectOfPrelection("test")
            .timeOfPrelection(new TimeOfPrelection())
            .amountOfUsers(0L)
            .build();

    PrelectionWithIdDto prelectionWithIdDto = PrelectionWithIdDto.builder()
            .id(1L)
            .subjectOfPrelection("test")
            .amountOfUsers(0L)
            .timeOfPrelection(new TimeOfPrelectionDto())
            .build();

    PrelectionDto prelectionDto = PrelectionDto.builder()
            .timeOfPrelection(new TimeOfPrelectionDto())
            .subjectOfPrelection("test")
            .amountOfUsers(1L)
            .build();
    @Test
    void getAllPrelections() {
        when(prelectionRepository.findAll()).thenReturn(List.of(prelection));
        when(prelectionService.getAllPrelections()).thenReturn(List.of(prelectionWithIdDto));
        assertEquals(List.of(prelectionWithIdDto),prelectionService.getAllPrelections());
        verify(prelectionRepository,times(2)).findAll();
        }

    @Test
    void addUserToPrelection() {
        when(prelectionRepository.findById(1L)).thenReturn(Optional.of(prelection));
        when(prelectionService.addUserToPrelection(1L)).thenReturn(prelectionDto);
        assertEquals(prelectionDto,prelectionService.addUserToPrelection(1L));
    }

}
