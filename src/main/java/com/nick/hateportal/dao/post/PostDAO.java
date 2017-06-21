package com.nick.hateportal.dao.post;


import com.nick.hateportal.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostDAO {

    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    void updatePost(Post post);

    void deletePost(Post post);

    List<Post> getStartPosts(int n);

    List<Post> getFivePostsDB(int page);
}
