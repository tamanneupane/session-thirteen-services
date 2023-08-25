package com.metta.doctor.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "Quote-API", url = "${feign-client.quote-api.url}")
public interface QuoteProxy {

    @GetMapping(value = "${feign-client.quote-api.get-all-quotes}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAllQuotes();
}
