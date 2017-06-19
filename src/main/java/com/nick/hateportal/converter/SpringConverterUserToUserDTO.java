package com.nick.hateportal.converter;


import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.User;
import org.springframework.core.convert.converter.Converter;

public class SpringConverterUserToUserDTO implements Converter<User,UserDTO> {

    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNickname(user.getNickname());
        userDTO.setUsername(user.getUsername());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRate(user.getRate());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
