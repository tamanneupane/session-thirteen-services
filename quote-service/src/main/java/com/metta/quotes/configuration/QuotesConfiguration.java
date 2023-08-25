package com.metta.quotes.configuration;

import com.metta.quotes.model.Quote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class QuotesConfiguration {

    @Bean
    @Lazy
    public Quote newInstance(){
        System.out.println("Object of quote is getting created");
        Quote quote = new Quote();
        System.out.println(quote);
        return quote;
    }
}
