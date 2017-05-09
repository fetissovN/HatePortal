package com.nick.hateportal.dao.post;

import com.nick.hateportal.entity.Post;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository("postDAOImpl")
@Transactional
public class PostDAOImpl implements PostDAO{

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void createPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
    }
}
