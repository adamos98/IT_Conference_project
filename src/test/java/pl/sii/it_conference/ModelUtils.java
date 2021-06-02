package pl.sii.it_conference;

import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserVO;

public class ModelUtils {

    public static UserVO getUserVO(){
        return UserVO.builder()
                .id(1L)
                .email(TestConst.EMAIL)
                .login(TestConst.LOGIN)
                .build();
    }

    public static UserDto getUserDto(){
        return UserDto.builder()
                .email(TestConst.EMAIL)
                .login(TestConst.LOGIN)
                .build();
    }
}
