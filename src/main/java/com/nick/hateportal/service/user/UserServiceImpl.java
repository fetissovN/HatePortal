package com.nick.hateportal.service.user;

import com.nick.hateportal.dao.user.UserDAO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.Mailing;
import com.nick.hateportal.utils.PassHash;
import com.nick.hateportal.utils.PasswordGenetator;
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
        if (user.getPassword().equals("")){
            User userDB = userDao.getUserById(user.getId());
            user.setPassword(userDB.getPassword());
            userDao.updateUser(user);
        }else {
            String pass = PassHash.stringPassToHash(user.getPassword());
            user.setPassword(pass);
            userDao.updateUser(user);
        }
    }

    @Override
    public String createDefaultUser(String name,String surname,String email) {
        String newPass =PasswordGenetator.genPass(6);
        String newHashPass = PassHash.stringPassToHash(newPass);
        User user = new User();
        user.setUsername(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(newHashPass);
        user.setNickname(name+" Hate");
        user.setRole(1);
        user.setRate(0.0);
        user.setPhone("00000000");
        createUser(user);
        return newPass;
    }

    @Override
    public void sendEmailToNewVkUser(String email, String newPass) {
        Mailing mailing = new Mailing();
        mailing.sendVkAuthMessageWithPassword(email, newPass);
    }


}
