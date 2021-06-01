package pl.sii.it_conference.serviceImplementation;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import pl.sii.it_conference.constant.ErrorMessage;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserEmailDto;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.entity.User;
import pl.sii.it_conference.exceptions.LoginAndEmailRegisteredException;
import pl.sii.it_conference.exceptions.LoginRegisteredException;
import pl.sii.it_conference.exceptions.NotFoundException;
import pl.sii.it_conference.repository.UserRepository;
import pl.sii.it_conference.service.UserService;
import java.util.List;

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
    public UserVO findByLogin(String login) {
        return modelMapper.map(userRepository.findByLogin(login).orElseThrow(() ->
                new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_LOGIN + login)),UserVO.class);
    }

    @Override
    public UserVO save(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        if((userRepository.findByLogin(userDto.getLogin()).isPresent() && userRepository.findByEmail(userDto.getEmail()).isPresent())) {
            throw new LoginAndEmailRegisteredException((String) ErrorMessage.LOGIN_AND_EMAIL_ALREADY_REGISTERED);
        }
        else if((userRepository.findByLogin(userDto.getLogin()).isPresent() && userRepository.findByEmail(userDto.getEmail()).isEmpty())){
            throw new LoginRegisteredException(ErrorMessage.LOGIN_ALREADY_REGISTERED);
        }
        userRepository.save(user);

        return modelMapper.map(user,UserVO.class);
    }

    @Override
    public UserDto updateEmail(UserEmailDto userEmailDto, String login) {
        User user = userRepository.findByLogin(login).orElseThrow(() ->
                new NotFoundException(ErrorMessage.USER_NOT_FOUND_BY_LOGIN + login));
        user.setEmail(userEmailDto.getEmail());
        User updated = userRepository.save(user);

        return modelMapper.map(updated,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDto>>() {
        }.getType());
    }
}
