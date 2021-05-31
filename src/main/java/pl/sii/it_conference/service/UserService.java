package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserVO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserVO getUserById(Long id);

    Optional<UserDto> findByLogin(String login);

    UserVO save(UserDto user);

    UserDto updateEmail(UserDto user, String newEmail,String login);

    List<UserDto> getAllUsers();

}
