package com.nick.hateportal.service.post;

import com.nick.hateportal.dao.user.UserDAO;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.junitString.TestPost;
import com.nick.hateportal.utils.junitString.TestUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:test-config.xml"})
public class PostServiceImplTest {

    private TestPost testPost;

    private TestUser testUser;

    private User idUser;

    private Post getPost;

    @Resource
    PostService postService;

    @Resource
    UserService userService;

    @Before
    public void setUp() throws Exception {
        testPost = new TestPost();
        testUser = new TestUser();
        userService.createUser(testUser.getTestUser());
        this.idUser = userService.getUserByEmail(testUser.EMAIL);
    }

    @Test
    public void createPost() throws Exception {
        Post post = testPost.getTestPost();
        post.setUserId(idUser);
        postService.createPost(post);
        this.getPost = postService.getLastPost();
        if (getPost!=null){
            assertTrue("Err wrong likes",getPost.getLike()==testPost.LIKE_COUNT);
            assertTrue("Err wrong post",getPost.getPost().equals(testPost.POST));
            assertTrue("Err wrong target",getPost.getTarget().equals(testPost.TARGET));
            assertTrue("Err wrong title",getPost.getTitle().equals(testPost.TITLE));
            assertTrue("Err wrong user",getPost.getUserId().getEmail().equals(idUser.getEmail()));
        }else {
            fail("user not saved or could not be read from db");
        }
    }

    @Test
    public void deletePost() throws Exception {
        try {
            createPost();
            postService.deletePostById(getPost.getId());

        }catch (Exception e){
            e.printStackTrace();
            fail("Delete error");
        }

    }

    @After
    public void tearDown() throws Exception {
        try {
            userService.deleteUser(idUser);
        }catch (Exception e){
            e.printStackTrace();
            fail("After error");
        }
    }

}