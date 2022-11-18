package com.example.cinemaroomproject.exceptions;

public class SeatException extends RuntimeException {

    private String msg;

    public SeatException() {
    }

    public SeatException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
