package com.metta.doctor.controller;

import com.metta.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/doctor-service/api/v1")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/ping")
    public String ping(){
        return "Doctor Service is up";
    }

    @GetMapping(value = "/doctor-quote")
    public Object doctorQuote(){
       return doctorService.callGetAllQuoteAPI();
    }
}
