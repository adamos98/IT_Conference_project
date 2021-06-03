package pl.sii.it_conference.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;
import pl.sii.it_conference.dto.UserWithIdDto;
import pl.sii.it_conference.entity.User;

@Component
public class UserVOMapper extends AbstractConverter<User, UserWithIdDto> {


    @Override
    protected UserWithIdDto convert(User user) {
        return UserWithIdDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
