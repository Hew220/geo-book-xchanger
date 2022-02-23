package hu.wup.geobookxchanger.gw.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorResponse {

    private  String message;
    private int status;
    private ZonedDateTime timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, int status, ZonedDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
