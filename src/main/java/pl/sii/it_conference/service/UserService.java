package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserWithIdDto;

import java.util.List;
public interface UserService {

    UserWithIdDto getUserById(Long id);

    UserWithIdDto findByLogin(String login);

    UserWithIdDto save(UserDto user);

    UserDto updateEmail(UserDto user);

    List<UserDto> getAllUsers();

}
