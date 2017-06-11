package com.nick.hateportal.service.user;


import com.nick.hateportal.entity.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

// returns new password
    String createDefaultUser(String name,String surname,String email);

    void sendEmailToNewVkUser(String email, String pass);

    List<User> getAllUsers();
}
