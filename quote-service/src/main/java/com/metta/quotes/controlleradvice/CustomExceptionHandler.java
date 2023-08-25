package com.metta.quotes.controlleradvice;


import com.metta.quotes.exception.QuoteNotFoundException;
import com.metta.quotes.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(QuoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleQuoteNotFoundException(QuoteNotFoundException quoteNotFoundException){
        ErrorResponse errorResponse = new ErrorResponse(quoteNotFoundException.getMessage(), quoteNotFoundException.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleOtherException(Exception exception){
//        ErrorResponse errorResponse = new ErrorResponse("Generic Error", 1000);
//        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
//    }

}
