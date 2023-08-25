package com.metta.quotes.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
public class QuoteNotFoundException extends RuntimeException{

    @Getter
    private String message;

    @Getter
    private int code;

    public QuoteNotFoundException(String message, int code){
        super(message); // Mandatory Step
        this.message = message;
        this.code = code;
    }
}
