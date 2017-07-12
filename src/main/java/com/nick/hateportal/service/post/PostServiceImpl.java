package com.nick.hateportal.service.post;

import com.nick.hateportal.dao.post.PostDAO;
import com.nick.hateportal.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Post getLastPost(){
        return postDAO.getLastPost();
    }

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = postDAO.getPostById(postId);
        return post;
    }

    @Override
    public void likePost(Long id) {
        Post post = getPostById(id);
        int count = post.getLike();
        count++;
        post.setLike(count);
        postDAO.updatePost(post);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = getPostById(id);
        postDAO.deletePost(post);
    }

    @Override
    public void deletePost(Post post) {
        postDAO.deletePost(post);
    }

    @Override
    public void updatePost(Post post, Long id) {
        Post postDB = getPostById(id);
        postDB.setTitle(post.getTitle());
        postDB.setTarget(post.getTarget());
        postDB.setPost(post.getPost());
        postDB.setPhoto(post.getPhoto());
        postDAO.updatePost(postDB);
    }

    /**
     * Deprecated method, use link further {@link PostServiceImpl#getFivePostsDB(int)}
     */
    @Deprecated
    @Override
    public List<Post> getFivePostsWithBoundaries(int page) {
        List<Post> allPosts = getAllPosts();
        List<Post> fivePosts = new ArrayList<>();
        int count ;
        if (page*5-allPosts.size()>=5){
            count = 0;
        }else {
            if (allPosts.size()-5<=5*page){
                count = allPosts.size()%5;
            }else {
                count = 5;
            }
        }
        for (int i=0; i<allPosts.size();i++){
            if(i==page*5){
                for (int j=0;j<count;j++) {
                    fivePosts.add(allPosts.get(i+j));
                }
                break;
            }
        }
        return fivePosts;
    }

    @Override
    public List<Post> getStartPosts(int n) {
        return postDAO.getStartPosts(n);
    }

    public List<Post> getFivePostsDB(int page){
        return postDAO.getFivePostsDB(page);
    }
}

