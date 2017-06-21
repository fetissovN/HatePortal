package com.nick.hateportal.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public abstract class ValidatorSample {

    public void valid(Errors errors,String strVal, String field, String logLong, String messaheLong, int numberOfChars) {

        if (strVal.length() > numberOfChars){
            errors.rejectValue(field, logLong, messaheLong);
        }
    }

    public void validNotBlank(Errors errors, String field, String logBlank, String messageBlank) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, logBlank, messageBlank);
    }
}
