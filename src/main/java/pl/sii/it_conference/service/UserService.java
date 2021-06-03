package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserVO;

import java.util.List;
public interface UserService {

    UserVO getUserById(Long id);

    UserVO findByLogin(String login);

    UserVO save(UserDto user);

    UserDto updateEmail(UserDto user);

    List<UserDto> getAllUsers();

}
