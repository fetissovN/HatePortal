package com.nick.hateportal.validation;


import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccountInfoFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "reg.nickname.empty", "Nickname must not be empty.");
        String nickname= user.getNickname();
        if (nickname.length() > 20){
            errors.rejectValue("nickname", "reg.nickname.tooLong", "Nickname must not more than 20 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "reg.username.empty", "Username must not be empty.");
        String username = user.getUsername();
        if (username.length() > 20){
            errors.rejectValue("username", "reg.username.tooLong", "Username must not more than 20 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "reg.phone.empty", "Phone must not be empty.");
        String phone = user.getPhone();
        if (phone.length() > 20){
            errors.rejectValue("phone", "reg.phone.tooLong", "Phone must not more than 20 characters.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "reg.surname.empty", "Surname must not be empty.");
        String surname = user.getSurname();
        if (surname.length() > 30){
            errors.rejectValue("surname", "reg.surname.tooLong", "Surname must not more than 30 characters.");
        }
        if(user.getPassword().equals("") && user.getPasswordCheck().equals("")){
        }else {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "reg.password.empty", "Password must not be empty.");
            if (!(user.getPassword()).equals(user
                    .getPasswordCheck())) {
                errors.rejectValue("passwordCheck", "reg.passwordCheck.passwordDontMatch", "Passwords don't match.");
            }
        }

        if( !EmailValidator.getInstance().isValid( user.getEmail() ) ){
            errors.rejectValue("email", "reg.email.notValid", "Email address is not valid.");
        }
    }
}
