package hu.wup.geobookxchanger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorResponse, notFound);
    }

    @ExceptionHandler(value = {BookIsAlreadyExistException.class})
    public ResponseEntity<Object> handleBookIsAlreadyExistException(BookIsAlreadyExistException ex) {
        HttpStatus conflict = HttpStatus.CONFLICT;
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                conflict,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorResponse, conflict);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
            HttpStatus notFound = HttpStatus.NOT_FOUND;
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                    notFound,
                    ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(errorResponse, notFound);
    }

    @ExceptionHandler(value = {UserIsAlreadyExist.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserIsAlreadyExist ex) {
            HttpStatus conflict = HttpStatus.CONFLICT;
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                    conflict,
                    ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(errorResponse, conflict);
    }

}
