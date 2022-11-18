package com.example.cinemaroomproject.exceptions;

public class SeatResponse {

    private String error;

    public SeatResponse() {
    }

    public SeatResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
