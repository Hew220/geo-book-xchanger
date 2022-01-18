package hu.wup.geobookxchanger.exceptions;

public class UserIsAlreadyExist extends RuntimeException{

    public UserIsAlreadyExist(String message) {
        super(message);
    }
}
