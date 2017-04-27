package com.nick.hateportal.validation;



import com.nick.hateportal.DTO.UserLoginDTO;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserLoginDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserLoginDTO user = (UserLoginDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "login.email.empty", "Username must not be empty.");
        String username = user.getEmail();
        if (username.length() > 30){
            errors.rejectValue("email", "login.email.tooLong", "Login must not more than 30 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password.empty", "Password must not be empty.");

    }
}
