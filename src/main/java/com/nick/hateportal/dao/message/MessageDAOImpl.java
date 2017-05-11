package com.nick.hateportal.dao.message;


import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository("messageDAOImpl")
@Transactional
public class MessageDAOImpl implements MessageDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void saveMessage(Message message) {
        sessionFactory.getCurrentSession().save(message);
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

        return messages;
    }
}
