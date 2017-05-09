package com.nick.hateportal.dao.post;

import com.nick.hateportal.entity.Post;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("postDAOImpl")
@Transactional
public class PostDAOImpl implements PostDAO{

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void createPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        criteria.addOrder(Order.desc("postDate"));
        List result = criteria.list();
        return result;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = sessionFactory.getCurrentSession().get(Post.class, id);
        return post;
    }
}
