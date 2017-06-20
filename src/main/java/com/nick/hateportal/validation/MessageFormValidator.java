package com.nick.hateportal.validation;


import com.nick.hateportal.entity.Message;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MessageFormValidator extends ValidatorSample implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Message.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Message post = (Message) o;

        validNotBlank(errors,post.getMessage(),"message", "post.message.empty", "Title must not be empty.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "post.message.empty", "Title must not be empty.");

    }
}
