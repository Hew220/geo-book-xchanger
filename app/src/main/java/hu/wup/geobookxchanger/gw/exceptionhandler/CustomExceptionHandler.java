package hu.wup.geobookxchanger.gw.exceptionhandler;

import feign.FeignException;
import hu.wup.geobookxchanger.gw.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {FeignException.class})
    public ResponseEntity<Object> handleFeignException(FeignException feignException) {
        int notFound = feignException.status();

        ErrorResponse errorResponse = new ErrorResponse(feignException.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(notFound));
    }
}
