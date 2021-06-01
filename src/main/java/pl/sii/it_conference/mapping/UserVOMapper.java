package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.entity.User;

@Component
public class UserVOMapper extends AbstractConverter<User,UserVO> {


    @Override
    protected UserVO convert(User user) {
        return UserVO.builder()
                .email(user.getEmail())
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
