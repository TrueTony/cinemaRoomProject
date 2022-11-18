package com.example.cinemaroomproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CashRegisterControllerAdvice {

    @ExceptionHandler(CashRegisterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CashRegisterResponse handleException(CashRegisterException exception) {
        return new CashRegisterResponse(exception.getMsg());
    }
}

