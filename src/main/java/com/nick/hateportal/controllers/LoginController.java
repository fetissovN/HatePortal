package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.PassHash;
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

@Controller
@RequestMapping(value = "/log")
public class LoginController {

    @Autowired
    private LoginFormValidator validator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showLoginFrom(HttpServletRequest request , HttpServletResponse response, HttpSession session, Model model){
        if (session.getAttribute("auth")!=null){
            session.removeAttribute("auth");
            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                cookie.setMaxAge(0);
                response.addCookie(cookie);
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
                cookie.htt;
                response.addCookie(cookie);
                return "redirect:/";
            }else {
                model.addAttribute("loginErr", "loginErr");
                return "login";
            }
        }
    }
}
