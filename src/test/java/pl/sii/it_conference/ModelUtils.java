package pl.sii.it_conference;

import pl.sii.it_conference.dto.*;
import pl.sii.it_conference.entity.TimeOfPrelection;

import java.sql.Time;

public class ModelUtils {

    public static UserWithIdDto getUserWithIdDto(){
        return UserWithIdDto.builder()
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

    public static PrelectionWithIdDto getPrelectionWithIdDto() {
        return PrelectionWithIdDto.builder()
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

    public static PrelectionDto getPrelectionDto(){
        return PrelectionDto.builder()
                .timeOfPrelection(getTimeOfPrelection())
                .amountOfUsers(0L)
                .subjectOfPrelection(TestConst.SUBJECTOFPRELECTION)
                .build();
    }

    public static ReservationWithIdDto getReservationWithIdDto(){
        return ReservationWithIdDto.builder()
                .id(1L)
                .prelection(getPrelectionDto())
                .user(getUserDto())
                .build();
    }

}
