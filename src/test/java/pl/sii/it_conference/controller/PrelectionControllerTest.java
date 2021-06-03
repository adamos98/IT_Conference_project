package pl.sii.it_conference.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.sii.it_conference.ModelUtils;
import pl.sii.it_conference.TestConst;
import pl.sii.it_conference.service.PrelectionService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PrelectionControllerTest {
    private static final String prelectionLink = "/prelection";
    private MockMvc mockMvc;
    @InjectMocks
    private PrelectionController prelectionController;
    @Mock
    private PrelectionService prelectionService;

    @BeforeEach
    void setup(){
        this.mockMvc = MockMvcBuilders.
                standaloneSetup(prelectionController)
                .build();
    }

    @Test
    void getAllPrelectionsTest() throws Exception {
        when(prelectionService.getAllPrelections()).thenReturn(List.of(ModelUtils.getPrelectionVO()));
        mockMvc.perform(get(prelectionLink + "/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].subjectOfPrelection").value(TestConst.SUBJECTOFPRELECTION))
                .andExpect(jsonPath("$[0].amountOfUsers").value(0L));
    }
}
