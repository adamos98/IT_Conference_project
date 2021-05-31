package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.entity.User;

@Component
public class UserVOMapper extends AbstractConverter<UserVO,User> {

    @Override
    protected User convert(UserVO userVO) {
        return User.builder()
                .id(userVO.getId())
                .email(userVO.getEmail())
                .login(userVO.getLogin())
                .build();
    }
}
