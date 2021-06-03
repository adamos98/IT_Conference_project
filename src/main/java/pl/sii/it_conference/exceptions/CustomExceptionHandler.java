package pl.sii.it_conference.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public String handleNotFoundException(NotFoundException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.NOT_FOUND);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
        return "error";
    }

    @ExceptionHandler(value = {NotDeletedException.class})
    public String handleNotDeletedException(NotDeletedException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.BAD_REQUEST);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
        return "error";
    }

    @ExceptionHandler(value = {FullPrelectionException.class})
    public String handleFullPrelectionException(FullPrelectionException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.BAD_REQUEST);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
        return "error";
    }

    @ExceptionHandler(value = {LoginAndEmailRegisteredException.class})
    public String handleLoginAndEmailRegisteredException(LoginAndEmailRegisteredException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.BAD_REQUEST);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
        return "error";
    }

    @ExceptionHandler(value = {LoginRegisteredException.class})
    public String handleLoginRegisteredException(LoginRegisteredException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.BAD_REQUEST);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
        return "error";
    }

    @ExceptionHandler(value = {UserAlreadyReservedPrelectionOnThatTimeException.class})
    public String handleUserAlreadyReservedPrelectionOnThatTimeException(UserAlreadyReservedPrelectionOnThatTimeException e, Model model){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));
        model.addAttribute("message",e.getMessage());
        model.addAttribute("httpStatus",HttpStatus.BAD_REQUEST);
        model.addAttribute("zonedDateTime",ZonedDateTime.now(ZoneId.of("Z")));
        //return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST); //return jako API
        return "error"; //Thymeleaf widok
    }

}
