package com.nick.hateportal.dao.user;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.WHERE;

@Repository("userDaoImpl")
@Transactional
public class UserDaoImpl implements UserDAO {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        LOGGER.info(messageSource.getMessage("log.new.user", new Object[] {user}, Locale.ENGLISH));
    }

    @Override
    public User getUserByEmail(String email) {

        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);

        List userEntities = query.list();
        if (userEntities.size()==0){
            return null;
        }
        User user = (User) userEntities.get(0);
        LOGGER.info(messageSource.getMessage("log.get.user.email", new Object[] {email}, Locale.ENGLISH));
//        User user = sessionFactory.getCurrentSession().get(User.class,email);
        return user;
    }

    @Override
    public void updateUser(User user) {

        sessionFactory.getCurrentSession().update(user);
        LOGGER.info(messageSource.getMessage("log.update.user", new Object[] {user}, Locale.ENGLISH));
    }

    @Override
    public User getUserById(Long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        LOGGER.info(messageSource.getMessage("log.get.userById", new Object[] {id}, Locale.ENGLISH));
        return user;
    }

    @Override
    public void updateUserInfoWithoutPassword(User user) {

    }

    @Override
    public List<User> getAllUsersDecrId() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));
        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("log.get.users", new Object[] {result}, Locale.ENGLISH));
        return result;
    }

    @Override
    public List<User> getAllUsersAscId() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.addOrder(Order.asc("id"));
        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("log.get.users", new Object[] {result}, Locale.ENGLISH));
        return result;
    }

}
