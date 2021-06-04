package pl.sii.it_conference.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import pl.sii.it_conference.TestConst;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserWithIdDto;
import pl.sii.it_conference.entity.User;
import pl.sii.it_conference.repository.UserRepository;
import pl.sii.it_conference.serviceImplementation.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private ModelMapper modelMapper;

    private UserWithIdDto userWithIdDto = UserWithIdDto.builder()
            .id(1L)
            .login("Tester2")
            .email("tester2@gmail.com")
            .build();

    private User user = User.builder()
            .id(1L)
            .login("Tester2")
            .email("tester2@gmail.com")
            .build();
    private User user2 = User.builder()
            .id(1L)
            .login("Testing")
            .email("Testing@testing.com")
            .build();

    private UserDto userDto = UserDto.builder()
            .email("tester2@gmail.com")
            .login("Tester2")
            .build();

    private String userEmail = user.getEmail();

    @Test
    void getUserById() {
        Long id = 1L;
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(modelMapper.map(user, UserWithIdDto.class)).thenReturn(userWithIdDto);
        assertEquals(userWithIdDto,userService.getUserById(id));
        verify(userRepository,times(1)).findById(id);
    }

    @Test
    void findByLogin() {
        User user = new User();
        user.setLogin(TestConst.LOGIN);
        when(userRepository.findByLogin(TestConst.LOGIN)).thenReturn(Optional.of(user));
        when(modelMapper.map(user,UserWithIdDto.class)).thenReturn(userWithIdDto);
        assertEquals(userWithIdDto,userService.findByLogin(TestConst.LOGIN));
        verify(userRepository,times(1)).findByLogin(TestConst.LOGIN);
    }

    @Test
    void save() {
        when(userRepository.findByLogin(userEmail)).thenReturn(Optional.ofNullable(user));
        when(userService.findByLogin(userEmail)).thenReturn(userWithIdDto);
        when(modelMapper.map(userWithIdDto,User.class)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(modelMapper.map(user,UserDto.class)).thenReturn(userDto);
        assertNull(userService.save(userDto));
    }

    @Test
    void updateEmail() {
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);

    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userService.getAllUsers()).thenReturn(List.of(userDto));
        assertEquals(List.of(userDto),userService.getAllUsers());
        verify(userRepository,times(2)).findAll();
    }
}
