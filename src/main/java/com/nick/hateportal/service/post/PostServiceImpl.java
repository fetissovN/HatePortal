package com.nick.hateportal.service.post;

import com.nick.hateportal.dao.post.PostDAO;
import com.nick.hateportal.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public void createPost(Post post) {
        postDAO.createPost(post);
    }
}
