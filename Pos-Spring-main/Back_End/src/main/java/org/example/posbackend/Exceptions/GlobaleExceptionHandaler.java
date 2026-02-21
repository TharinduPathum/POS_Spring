package org.example.posbackend.Exceptions;

import jakarta.persistence.EntityExistsException;
import org.example.posbackend.Util2.APIRespons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobaleExceptionHandaler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIRespons<String>> handleGeneralExceptions(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new APIRespons<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIRespons<String>> handleGeneralNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(new APIRespons<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<APIRespons<String>>
    AlreadyAvailableEntityExistsException(EntityExistsException e) {

        return
                new ResponseEntity<>(new APIRespons<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);


    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIRespons<Object>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String, String> error = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            error.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        });

        return new ResponseEntity<>(
                new APIRespons<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Bad Request",
                        error
                ),
                HttpStatus.BAD_REQUEST
        );
    }


}
