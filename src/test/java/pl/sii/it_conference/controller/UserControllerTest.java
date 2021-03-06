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
import pl.sii.it_conference.dto.UserWithIdDto;
import pl.sii.it_conference.service.UserService;

import java.util.List;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserControllerTest {
    private static final String userLink = "/user";
    private MockMvc mockMvc;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;


    @BeforeEach
    void setup(){
        this.mockMvc = MockMvcBuilders.
                standaloneSetup(userController)
                .build();
    }

    @Test
    void getUserByIdTest() throws Exception {
        UserWithIdDto userWithIdDto = ModelUtils.getUserWithIdDto();
        when(userService.getUserById(1L)).thenReturn(userWithIdDto);
        mockMvc.perform(get(userLink + "/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.login").value(TestConst.LOGIN))
                .andExpect(jsonPath("$.email").value(TestConst.EMAIL));

        verify(userService).getUserById(1L);
    }

    @Test
    void getUserByLoginTest() throws Exception {
        UserWithIdDto userWithIdDto = ModelUtils.getUserWithIdDto();
        when(userService.findByLogin(TestConst.LOGIN)).thenReturn(userWithIdDto);
        mockMvc.perform(get(userLink + "/login/{login}",TestConst.LOGIN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.login").value(TestConst.LOGIN))
                .andExpect(jsonPath("$.email").value(TestConst.EMAIL));

        verify(userService).findByLogin(TestConst.LOGIN);
    }

    @Test
    void addNewUserTest() throws Exception {
        when(userService.save(ModelUtils.getUserDto())).thenReturn(ModelUtils.getUserWithIdDto());
        String content = "{\n"
                + "  \"email\": \"tester@gmail.com\",\n"
                + "  \"login\": \"Tester\"\n"
                + "}";
        mockMvc.perform(post(userLink + "/addNewUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                        .andExpect(status().isCreated());

        verify(userService).save(ModelUtils.getUserDto());
    }

    @Test
    void updateEmailTest() throws Exception {
        when(userService.updateEmail(ModelUtils.getUserDto())).thenReturn(ModelUtils.getUserDto());

        String content = "{\n"
                + "  \"email\": \"tester@gmail.com\",\n"
                + "  \"login\": \"Tester\"\n"
                + "}";

        mockMvc.perform(put(userLink + "/updateLogin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.login").value(TestConst.LOGIN))
                .andExpect(jsonPath("$.email").value(TestConst.EMAIL));

       verify(userService).updateEmail(ModelUtils.getUserDto());
    }

    @Test
    void getAllUsersTest() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(ModelUtils.getUserDto()));
        mockMvc.perform(get(userLink + "/allUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].login").value(TestConst.LOGIN))
                .andExpect(jsonPath("$[0].email").value(TestConst.EMAIL));
    }
}
