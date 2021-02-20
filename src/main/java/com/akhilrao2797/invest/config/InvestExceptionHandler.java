package com.akhilrao2797.invest.config;

import com.akhilrao2797.invest.models.exception.CustomException;
import com.akhilrao2797.invest.models.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<CustomException> handleAllExceptions(UserNotFoundException ex){
        CustomException exception = new CustomException(400, ex.getMessageId(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
