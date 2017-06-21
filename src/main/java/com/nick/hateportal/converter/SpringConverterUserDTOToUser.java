package com.nick.hateportal.converter;


import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.UtilsDB;
import com.nick.hateportal.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class SpringConverterUserDTOToUser implements Converter<UserDTO, User>{


    @Autowired
    private UserService userService;


    public User convert(UserDTO userDTO){
        User user = userService.getUserById(userDTO.getId());
        user.setNickname(userDTO.getNickname());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setRate(userDTO.getRate());
        user.setRole(userDTO.getRole());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
