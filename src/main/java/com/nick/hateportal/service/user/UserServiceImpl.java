package com.nick.hateportal.service.user;

import com.nick.hateportal.dao.user.UserDAO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Autowired
    Utils utils;

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        String refactorEmail = utils.stringToLowerCase(email);
        User user = userDao.getUserByEmail(refactorEmail);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
