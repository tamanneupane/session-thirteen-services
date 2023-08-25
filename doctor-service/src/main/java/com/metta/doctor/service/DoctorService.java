package com.metta.doctor.service;

import com.metta.doctor.feing.QuoteProxy;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private QuoteProxy quoteProxy;

    public Object callGetAllQuoteAPI(){
        try{
            ResponseEntity<Object> proxyResp = quoteProxy.getAllQuotes();

            Optional<ResponseEntity<Object>> optionalResponse = Optional.ofNullable(proxyResp);

            if(optionalResponse.isPresent()){
                System.out.println(proxyResp.getStatusCode());
                return proxyResp.getBody();
            }
        }catch (RetryableException e){
            throw new RuntimeException(e.getMessage());
        }


        throw new RuntimeException("Unable to make API call");

    }
}
