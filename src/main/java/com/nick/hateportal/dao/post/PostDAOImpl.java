package com.nick.hateportal.dao.post;

import com.nick.hateportal.entity.Post;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository("postDAOImpl")
@Transactional
public class PostDAOImpl implements PostDAO{

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void createPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
        LOGGER.info(messageSource.getMessage("log.new.post", new Object[] {post}, Locale.ENGLISH));

    }

    @Override
    public List<Post> getAllPosts() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        criteria.addOrder(Order.desc("postDate"));
        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("log.get.posts", new Object[] {result}, Locale.ENGLISH));
        return result;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = sessionFactory.getCurrentSession().get(Post.class, id);
        LOGGER.info(messageSource.getMessage("log.get.post", new Object[] {id}, Locale.ENGLISH));
        return post;
    }

    @Override
    public void updatePost(Post post) {
        sessionFactory.getCurrentSession().update(post);
        LOGGER.info(messageSource.getMessage("log.update.post", new Object[] {post}, Locale.ENGLISH));

    }

    @Override
    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
        LOGGER.info(messageSource.getMessage("log.delete.post", new Object[] {post}, Locale.ENGLISH));
    }

    @Override
    public List<Post> getStartPosts(int n){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        criteria.addOrder(Order.desc("postDate"));
        criteria.setMaxResults(n);
        List result = criteria.list();
        LOGGER.info(messageSource.getMessage("log.get.posts.start", new Object[] {result}, Locale.ENGLISH));
        return result;
    }
}
