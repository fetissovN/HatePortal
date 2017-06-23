package com.nick.hateportal.utils.login;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertNewUserRegDtoToUser implements Converter<UserRegDTO,User> {

    @Override
    public User convert(UserRegDTO userRegDTO) {
        User user = new User();
        user.setNickname(userRegDTO.getNickname());
        user.setEmail(userRegDTO.getEmail());
        user.setPhone(userRegDTO.getPhone());
        user.setRate(0.0);
        user.setUsername(userRegDTO.getUsername());
        user.setSurname(userRegDTO.getSurname());
        user.setRole(1);
        user.setPassword(userRegDTO.getPassword());
        return user;
    }
}
