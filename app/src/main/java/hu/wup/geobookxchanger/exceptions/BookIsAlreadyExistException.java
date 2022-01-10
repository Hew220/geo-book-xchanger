package hu.wup.geobookxchanger.exceptions;

public class BookIsAlreadyExistException extends RuntimeException {

    public BookIsAlreadyExistException(String message) {
        super(message);
    }
}
