package com.example.cinemaroomproject.exceptions;

public class CashRegisterException extends RuntimeException {

    private String msg;

    public CashRegisterException() {
    }

    public CashRegisterException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
