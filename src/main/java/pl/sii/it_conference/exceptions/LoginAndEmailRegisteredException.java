package pl.sii.it_conference.exceptions;

public class LoginAndEmailRegisteredException extends RuntimeException{

    public LoginAndEmailRegisteredException(String message){
        super(message);
    }
}
