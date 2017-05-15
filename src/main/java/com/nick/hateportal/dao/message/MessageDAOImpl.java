package com.nick.hateportal.dao.message;


import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

@Repository("messageDAOImpl")
@Transactional
public class MessageDAOImpl implements MessageDAO {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void saveMessage(Message message) {
        sessionFactory.getCurrentSession().save(message);
        LOGGER.info(messageSource.getMessage("log.new.message", new Object[] {message}, Locale.ENGLISH));

    }

    @Override
    public void deleteMessage(Message message) {

    }

    @Override
    public void uptadeMessage(Message message) {

    }

    @Override
    public List<Message> getAllMessagesByPostId(Post post) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Message.class)
                .add(Restrictions.eq("post_id", post));
        criteria.addOrder(Order.desc("message_date"));

        List<Message> messages = criteria.list();
        LOGGER.info(messageSource.getMessage("log.get.messages", new Object[] {messages}, Locale.ENGLISH));
        return messages;
    }
}
