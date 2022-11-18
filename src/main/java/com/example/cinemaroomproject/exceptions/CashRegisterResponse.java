package com.example.cinemaroomproject.exceptions;

public class CashRegisterResponse {

    private String error;

    public CashRegisterResponse() {
    }

    public CashRegisterResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
