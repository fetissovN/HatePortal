package com.nick.hateportal.service.post;

import com.nick.hateportal.entity.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 08.05.2017.
 */
public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    void likePost(Long id);
}
