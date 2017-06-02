package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.PassHash;
import com.nick.hateportal.utils.Vk;
import com.nick.hateportal.validation.LoginFormValidator;
import com.nick.hateportal.validation.RegFormValidator;
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
import java.util.Date;

@Controller
@RequestMapping(value = "/log")
public class LoginController {

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
        response.toString();
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
}
