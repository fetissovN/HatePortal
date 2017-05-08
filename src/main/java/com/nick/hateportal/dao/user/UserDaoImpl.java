package com.nick.hateportal.dao.user;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.WHERE;

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

    @Override
    public User getUserByEmail(String email) {

        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);

        List userEntities = query.list();
        User user = (User) userEntities.get(0);

//        User user = sessionFactory.getCurrentSession().get(User.class,email);
        return user;
    }
}
