package com.metta.quotes.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ErrorResponse {

    private String status = "ERROR";
    private String message;
    private int errorCode;
    private LocalDateTime errorTimeStamp = LocalDateTime.now();

    public ErrorResponse(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
