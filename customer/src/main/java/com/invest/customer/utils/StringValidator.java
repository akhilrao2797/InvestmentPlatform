package com.invest.customer.utils;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<NotNullAndNotEmpty, String> {
    @Override
    public void initialize(NotNullAndNotEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return !StringUtils.isEmpty(field);
    }
}
