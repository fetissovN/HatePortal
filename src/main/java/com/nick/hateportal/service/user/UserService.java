package com.nick.hateportal.service.user;


import com.nick.hateportal.entity.User;

public interface UserService {

    void createUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);
}
