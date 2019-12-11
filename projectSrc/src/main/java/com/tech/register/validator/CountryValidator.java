package com.tech.register.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class CountryValidator implements ConstraintValidator<CountrySpecific, String> {
    private static final String COUNTRY = "France";

    @Override
    public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
        return country != null && country.equalsIgnoreCase(COUNTRY);
    }
}
