package com.nick.hateportal.converter;


import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.User;

public class DTOConverter {

    public static UserDTO convertUserToUserDto(User user){
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
