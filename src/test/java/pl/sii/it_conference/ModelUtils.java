package pl.sii.it_conference;

import pl.sii.it_conference.dto.PrelectionVO;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.entity.TimeOfPrelection;

import java.sql.Time;

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

    public static PrelectionVO getPrelectionVO() {
        return PrelectionVO.builder()
                .id(1L)
                .subjectOfPrelection(TestConst.SUBJECTOFPRELECTION)
                .amountOfUsers(0L)
                .timeOfPrelection(getTimeOfPrelection())
                .build();
    }

    public static TimeOfPrelection getTimeOfPrelection(){
        return TimeOfPrelection.builder()
                .id(1L)
                .startOfPrelection(new Time(1,1,1))
                .endOfPrelection(new Time(2,2,2))
                .build();
    }


}
