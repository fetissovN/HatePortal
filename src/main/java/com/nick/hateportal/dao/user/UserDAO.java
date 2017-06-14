package com.nick.hateportal.dao.user;


import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

    User getUserById(Long id);

    void updateUserInfoWithoutPassword(User user);

    List<User> getAllUsersDecrId();

    List<User> getAllUsersAscId();
}
