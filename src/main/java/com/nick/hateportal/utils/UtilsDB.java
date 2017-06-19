package com.nick.hateportal.utils;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilsDB {

    @Autowired
    private static UserService userService;

    public static boolean checkEmail(String emailUser, String emailUserDTO) throws EmailExistsException {
            if (emailUser.equals(emailUserDTO)){
                return true;
            }else {
                if (userService.getUserByEmail(emailUserDTO)==null){
                    return true;
                }else {
                    throw new EmailExistsException();
                }
            }
    }
}
