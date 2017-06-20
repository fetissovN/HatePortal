package com.nick.hateportal.validation;



import com.nick.hateportal.DTO.UserLoginDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator extends ValidatorSample implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserLoginDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserLoginDTO user = (UserLoginDTO) o;
        validNotBlank(errors,user.getEmail(),"email","login.email.empty","Username must not be empty.");
        valid(errors,user.getEmail(),"email","login.email.tooLong","Login must not more than 30 characters.",30);
        validNotBlank(errors,user.getPassword(),"password","login.password.empty","Password must not be empty.");

//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "login.email.empty", "Username must not be empty.");
//        String username = user.getEmail();
//        if (username.length() > 30){
//            errors.rejectValue("email", "login.email.tooLong", "Login must not more than 30 characters.");
//        }
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password.empty", "Password must not be empty.");

    }

}
