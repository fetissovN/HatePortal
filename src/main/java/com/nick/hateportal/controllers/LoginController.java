package com.nick.hateportal.controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.PassHash;
import com.nick.hateportal.utils.Vk;
import com.nick.hateportal.utils.exception.MailingException;
import com.nick.hateportal.validation.LoginFormValidator;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5;

@Controller
@RequestMapping(value = "/log")
public class LoginController extends ExceptionsController {

    @Autowired
    private LoginFormValidator validator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showLoginFrom(HttpServletRequest request , HttpServletResponse response, HttpSession session, Model model){
//        Vk vk = new Vk();
//        try {
//            vk.test();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (session.getAttribute("auth")!=null){
            session.removeAttribute("auth");
//            Cookie cookie = null;
//            cookies = null;
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("auth")){
                    System.out.println(cookies[i].getName());
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            return "redirect:/";
        }
        model.addAttribute("loginForm", new UserLoginDTO());
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute(value = "loginForm") UserLoginDTO loginDTO, HttpServletResponse response, HttpSession session, Model model, BindingResult result){
        validator.validate(loginDTO, result);
        if (result.hasErrors()){
            return "login";
        }
        User userFromDB = userService.getUserByEmail(loginDTO.getEmail());
        if (userFromDB==null){
            model.addAttribute("loginErr", "loginErr");
            return "login";
        }else {
            PassHash passHash = new PassHash();
            String pass = passHash.stringPassToHash(loginDTO.getPassword());
            if (userFromDB.getPassword().equals(pass)){
                session.removeAttribute("auth");
                session.setAttribute("auth", DTOConverter.convertUserToUserDto(userFromDB));
                Cookie cookie = new Cookie("auth","1");
                cookie.setMaxAge(7);
                cookie.setPath("/");
                cookie.setSecure(false);
                cookie.setHttpOnly(true);

//                cookie.htt;
                Cookie cookietimestamp = new Cookie("timestamp", new Long(new Date().getTime()).toString());
                cookietimestamp.setPath("/showInfo");
                cookietimestamp.setSecure(false);
                cookietimestamp.setHttpOnly(true);
                cookietimestamp.setMaxAge(32436356);
                response.addCookie(cookietimestamp);
                response.addCookie(cookie);
                return "redirect:/";
            }else {
                model.addAttribute("loginErr", "loginErr");
                return "login";
            }
        }
    }

    @RequestMapping(value = "/vk.login")
    public String vkLogin(HttpServletRequest request){
        String codeHttp= Vk.getCodeHttp();
        return "redirect:" + codeHttp;
    }

    @RequestMapping(value = "/log.access")
    public String loginFinalVk(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){
        String code = request.getParameter("code");
        HashMap<String,String> userInfo= Vk.finalHttp(code);
        if (userInfo!=null){
            String email = userInfo.get("email");
            User userFromDB = userService.getUserByEmail(email);
            session.removeAttribute("auth");

            if (userFromDB!=null){
                session.setAttribute("auth", DTOConverter.convertUserToUserDto(userFromDB));
                return "redirect:/";
            }else {
                String passForEmail = userService.createDefaultUser(userInfo.get("first_name"),userInfo.get("last_name"),email);
                try {
                    userService.sendEmailToNewVkUser(email, passForEmail);
                } catch (MailingException e) {
                    e.printStackTrace();
                }
                User user = userService.getUserByEmail(email);
                session.setAttribute("auth", DTOConverter.convertUserToUserDto(user));

            }
        }
        return "redirect:/";
    }
}
