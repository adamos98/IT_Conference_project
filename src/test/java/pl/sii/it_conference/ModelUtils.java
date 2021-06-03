package pl.sii.it_conference;

import pl.sii.it_conference.dto.*;

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
                .timeOfPrelection(getTimeOfPrelectionDto())
                .build();
    }

    public static TimeOfPrelectionDto getTimeOfPrelectionDto(){
        return TimeOfPrelectionDto.builder()
                .startOfPrelection(new Time(1,1,1))
                .endOfPrelection(new Time(1,1,1))
                .build();
    }

    public static PrelectionDto getPrelectionDto(){
        return PrelectionDto.builder()
                .amountOfUsers(0L)
                .subjectOfPrelection(TestConst.SUBJECTOFPRELECTION)
                .timeOfPrelection(getTimeOfPrelectionDto())
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
