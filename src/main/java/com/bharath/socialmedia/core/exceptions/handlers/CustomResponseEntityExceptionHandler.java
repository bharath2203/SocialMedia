package com.bharath.socialmedia.core.exceptions.handlers;

import com.bharath.socialmedia.core.exceptions.UserNotFoundException;
import com.bharath.socialmedia.core.exceptions.object.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Optional;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        Error error = Error.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        Error error = Error.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Optional<ObjectError> objectError = ex.getAllErrors().stream().findFirst();

        String errMessage = "validation error";

        if(objectError.isPresent()) {
            errMessage = objectError.get().getDefaultMessage();
        }

        Error error = Error.builder()
                .message(errMessage)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
