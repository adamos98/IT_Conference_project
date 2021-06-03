package pl.sii.it_conference.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.sii.it_conference.ModelUtils;
import pl.sii.it_conference.TestConst;
import pl.sii.it_conference.service.ReservationService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ReservationControllerTest {
    private static final String reservationLink = "/reservation";
    private MockMvc mockMvc;
    @InjectMocks
    private ReservationController reservationController;
    @Mock
    private ReservationService reservationService;

    @BeforeEach
    void setup(){
        this.mockMvc = MockMvcBuilders.
                standaloneSetup(reservationController)
                .build();
    }

    @Test
    void addNewReservation() throws Exception {
        when(reservationService.addNewReservation(ModelUtils.getUserDto(),1L))
                .thenReturn(ModelUtils.getReservationWithIdDto());
        String content = "{\n"
                + "  \"email\": \"tester@gmail.com\",\n"
                + "  \"login\": \"Tester\"\n"
                + "}";
        mockMvc.perform(post(reservationLink + "/addReservation/{prelectionId}",1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andExpect(status().isCreated());

        verify(reservationService).addNewReservation(ModelUtils.getUserDto(),1L);
    }

    @Test
    void showReservationsByLogin() throws Exception {
        when(reservationService.showReservationsByLogin(TestConst.LOGIN)).thenReturn(List.of(ModelUtils.getReservationWithIdDto()));
        mockMvc.perform(get(reservationLink + "/showReservationsByLogin/{login}",TestConst.LOGIN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].user").value(ModelUtils.getUserDto()));

        verify(reservationService).showReservationsByLogin(TestConst.LOGIN);
    }

    @Test
    void deleteReservation() throws Exception {
        when(reservationService.deleteReservation(1L)).thenReturn(1L);
        mockMvc.perform(delete(reservationLink + "/deleteReservation/{id}",1L))
                .andExpect(status().isOk());

        verify(reservationService).deleteReservation(1L);
    }
}
