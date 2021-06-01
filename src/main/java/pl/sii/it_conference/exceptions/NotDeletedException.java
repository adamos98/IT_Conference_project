package pl.sii.it_conference.exceptions;

public class NotDeletedException extends RuntimeException{
    public NotDeletedException(String message) {
        super(message);
    }
}
