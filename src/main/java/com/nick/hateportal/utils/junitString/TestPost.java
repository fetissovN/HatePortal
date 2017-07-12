package com.nick.hateportal.utils.junitString;


import com.nick.hateportal.entity.Post;

import java.util.Date;

public class TestPost {

    public static final Long ID= 999999999999999999L;
    public static final String TARGET= "target";
    public static final String TITLE = "title";
    public static final String POST= "post";
    public static final Date POST_DATE = new Date();
    public static final int LIKE_COUNT= 23;
    public static final byte[] PHOTO= null;

    public static Post getTestPost(){
        Post post = new Post();
        post.setTarget(TARGET);
        post.setTitle(TITLE);
        post.setPhoto(PHOTO);
        post.setPost(POST);
        post.setPostDate(POST_DATE);
        post.setLike(LIKE_COUNT);
        post.setPhoto(PHOTO);
        post.setId(ID);
        return post;
    }


}
