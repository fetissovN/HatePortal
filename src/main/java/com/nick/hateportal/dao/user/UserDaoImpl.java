package com.nick.hateportal.dao.user;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl implements UserDAO {

    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
