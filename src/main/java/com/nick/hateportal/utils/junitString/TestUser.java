package com.nick.hateportal.utils.junitString;

import com.nick.hateportal.entity.User;


public class TestUser {

    public static final String name = "test";
    public static final String surname = "testSurname";
    public static final String nick= "testNick";
    public static final String email= "fet@gmail.com";
    public static final String password= "12345";
    public static final String phone= "12345678";
    public static final String passCheck= "aa9b53dca45dad0a1d81e7462d8d573f";


    public User getTestUser(){
        User user = new User();
        user.setNickname(nick);
        user.setUsername(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(1);
        user.setRate(0.0);
        return user;
    }

}
