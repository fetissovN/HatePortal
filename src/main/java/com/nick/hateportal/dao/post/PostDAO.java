package com.nick.hateportal.dao.post;


import com.nick.hateportal.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostDAO {

    void createPost(Post post);

    List<Post> getAllPosts();
}
