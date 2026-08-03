package Exceptions;

public class InvalidGameDataException extends Exception {
    public InvalidGameDataException(String message, Throwable cause){
        super(message, cause);
    }
}
