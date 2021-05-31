package pl.sii.it_conference.serviceImplementation;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.sii.it_conference.constant.ErrorMessage;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.exceptions.NotFoundException;
import pl.sii.it_conference.repository.UserRepository;
import pl.sii.it_conference.service.UserService;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public UserVO getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(() ->
        new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_ID + id)),UserVO.class);
    }

    @Override
    public Optional<UserDto> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public UserVO save(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateEmail(UserDto user, String newEmail, String login) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
