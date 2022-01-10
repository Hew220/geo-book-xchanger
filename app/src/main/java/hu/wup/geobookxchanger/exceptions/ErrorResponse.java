package hu.wup.geobookxchanger.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorResponse {

    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timeStamp;

    public ErrorResponse(String message, HttpStatus status, ZonedDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
