package com.nick.hateportal.service.user;

import com.nick.hateportal.dao.user.UserDAO;
import com.nick.hateportal.dao.user.UserDaoImpl;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.Utils;
import com.nick.hateportal.utils.junitString.TestUser;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest extends TestCase {

    TestUser testUser;

    @Resource
    UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        testUser = new TestUser();
    }

    @Test
    public void testCreateUser() throws Exception {
        User userTest = testUser.getTestUser();
        userDAO.createUser(userTest);
        User user = userDAO.getUserByEmail(testUser.EMAIL);
        if (user==null){
            fail("User was not saved");
        }else {
            assertTrue("Err",user.getNickname().equals(testUser.NICK));
            assertTrue("Err",user.getUsername().equals(testUser.NAME));
            assertTrue("Err",user.getSurname().equals(testUser.SURNAME));
            assertTrue("Err",user.getEmail().equals(testUser.EMAIL));
            assertTrue("Err",user.getPhone().equals(testUser.PHONE));
            assertTrue("Err",user.getPassword().equals(testUser.PASSWORD));
            assertTrue("Err",user.getRole()==1);
            assertTrue("Err",user.getRate()==0.0);
        }
        userDAO.deleteUser(user);
    }

    @After
    public void tearDown() throws Exception{
        userDAO.deleteUser(testUser.getTestUser());
    }

}