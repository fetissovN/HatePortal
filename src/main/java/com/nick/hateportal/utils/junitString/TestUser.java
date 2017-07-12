package com.nick.hateportal.utils.junitString;

import com.nick.hateportal.entity.User;


public class TestUser {

    public static final String NAME= "test";
    public static final String SURNAME= "testSurname";
    public static final String NICK= "testNick";
    public static final String EMAIL= "fet@gmail.com";
    public static final String PASSWORD= "12345";
    public static final String PHONE= "12345678";
    public static final String PASS_CHECK= "aa9b53dca45dad0a1d81e7462d8d573f";


    public User getTestUser(){
        User user = new User();
        user.setNickname(NICK);
        user.setUsername(NAME);
        user.setSurname(SURNAME);
        user.setEmail(EMAIL);
        user.setPhone(PHONE);
        user.setPassword(PASSWORD);
        user.setRole(1);
        user.setRate(0.0);
        return user;
    }

}
