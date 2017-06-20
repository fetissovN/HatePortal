package com.nick.hateportal.validation;


import com.nick.hateportal.DTO.UserRegDTO;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegFormValidator extends ValidatorSample implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegDTO user = (UserRegDTO) o;

        validNotBlank(errors, "nickname", "reg.nickname.empty", "Nickname must not be empty.");
        valid(errors,user.getNickname(),"nickname", "reg.nickname.tooLong", "Nickname must not more than 20 characters.",20);

        validNotBlank(errors, "username", "reg.username.empty", "Username must not be empty.");
        valid(errors,user.getUsername(),"username", "reg.username.tooLong", "Username must not more than 20 characters.",20);

        validNotBlank(errors, "phone", "reg.phone.empty", "Phone must not be empty.");
        valid(errors,user.getPhone(), "phone", "reg.phone.tooLong", "Phone must not more than 20 characters.",20);

        validNotBlank(errors,"surname", "reg.surname.empty", "Surname must not be empty.");
        valid(errors,user.getSurname(), "surname", "reg.surname.tooLong", "Surname must not more than 30 characters.",30);

        validNotBlank(errors,"password", "reg.password.empty", "Password must not be empty.");
        if (!(user.getPassword()).equals(user
                .getPasswordCheck())) {
            errors.rejectValue("passwordCheck", "reg.passwordCheck.passwordDontMatch", "Passwords don't match.");
        }

        if( !EmailValidator.getInstance().isValid( user.getEmail() ) ){
            errors.rejectValue("email", "reg.email.notValid", "Email address is not valid.");
        }
    }
}
