package pl.sii.it_conference.exceptions;

public class UserAlreadyReservedPrelectionOnThatTimeException extends RuntimeException{
    public UserAlreadyReservedPrelectionOnThatTimeException(String message) {
        super(message);
    }
}
