package com.metta.quotes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class LanguageValidator implements ConstraintValidator<Language, String> {

    List<String> acceptedLanguage = List.of("en", "jp");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Objects.isNull(value)) return false;
        return acceptedLanguage.contains(value);
    }
}
