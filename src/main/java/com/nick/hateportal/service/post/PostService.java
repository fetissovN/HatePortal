package com.nick.hateportal.service.post;

import com.nick.hateportal.entity.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostService {

    void createPost(Post post);

    Post getLastPost();

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    void likePost(Long id);

    void deletePostById(Long id);

    void deletePost(Post post);

    void updatePost(Post post, Long id);

    List<Post> getFivePostsWithBoundaries(int page);

    List<Post> getStartPosts(int n);

    List<Post> getFivePostsDB(int page);
}
