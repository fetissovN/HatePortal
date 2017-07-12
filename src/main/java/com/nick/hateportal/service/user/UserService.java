package com.nick.hateportal.service.user;


import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.exception.MailingException;

import java.util.List;

public interface UserService {

    void persistUser(User user);

    void createUser(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void updateUser(User user);

// returns new password
    String createDefaultUser(String name,String surname,String email);

    void sendEmailToNewVkUser(String email, String pass) throws MailingException;

    List<User> getAllUsersAscId();

    void deleteUser(User user);
}
