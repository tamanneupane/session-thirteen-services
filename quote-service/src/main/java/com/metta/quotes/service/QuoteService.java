package com.metta.quotes.service;


import com.metta.quotes.exception.QuoteNotFoundException;
import com.metta.quotes.model.Quote;
import com.metta.quotes.model.QuoteDTO;
import com.metta.quotes.repository.QuoteRepository;
import com.metta.quotes.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote storeQuote(QuoteDTO quoteDTO){
        // Save the data to database
        System.out.println(quoteDTO);
        return quoteRepository.save(quoteDTO.mapQuoteDtoToQuote());
    }

    public List<Quote> readQuotes(){
        return quoteRepository.findAll();
    }

    public Quote updateQuote(Long quoteId, QuoteDTO quoteDTO) throws RuntimeException{
        Optional<Quote> quoteOpt = quoteRepository.findById(quoteId);
        if(quoteOpt.isPresent()){
            Quote quote = quoteOpt.get();
            quote.setMessage(quoteDTO.getMessage());
            quote.setEnabled(quoteDTO.isEnabled());
            quote.setLanguage(quoteDTO.getLanguage());
            return quoteRepository.save(quote);
        }else {
            throw new QuoteNotFoundException(Constants.QUOTES_NOT_FOUND, 10001);
        }
    }

    public void deleteQuoteById(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    public Quote readSingleQuote(Long quoteId) {
        Optional<Quote> quoteOpt = quoteRepository.findById(quoteId);
        if(quoteOpt.isPresent()){
            return quoteOpt.get();
        }
        throw new QuoteNotFoundException(Constants.QUOTES_NOT_FOUND, 10001);
    }
}
