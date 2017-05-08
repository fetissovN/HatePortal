package com.nick.hateportal.service.post;

import com.nick.hateportal.dao.post.PostDAO;
import com.nick.hateportal.entity.Post;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public void createPost(Post post) {
        postDAO.createPost(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }
}
