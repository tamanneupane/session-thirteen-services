package com.metta.quotes.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.metta.quotes.validator.Language;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ToString
public class QuoteDTO {

    @Getter
    @Setter
    @JsonProperty(value = "message")
    @NotNull(message = "Message should be provided")
    @NotBlank(message = "Message should not be empty")
    private String message;

    @Getter
    @Setter
    @JsonProperty(value = "language")
    @NotNull(message = "Language should be provided")
    @Language(message = "Language beside en is not allowed")
    private String language;

    @Getter
    @Setter
    @JsonProperty(value = "enabled")
    @NotNull
    private boolean isEnabled;

    public Quote mapQuoteDtoToQuote(){
      Quote quote = new Quote();
      quote.setMessage(this.getMessage());
      quote.setEnabled(this.isEnabled());
      quote.setLanguage(this.getLanguage());
      return quote;
    };
}
