package com.nick.hateportal.service.post;

import com.nick.hateportal.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostService {

    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    void likePost(Long id);

    void deletePost(Long id);

    void updatePost(Post post, Long id);
}
