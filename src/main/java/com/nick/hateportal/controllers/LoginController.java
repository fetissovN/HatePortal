package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.converter.SpringConverterUserToUserDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.login.SessionCheckLogin;
import com.nick.hateportal.utils.password.PassHash;
import com.nick.hateportal.utils.vk.Vk;
import com.nick.hateportal.utils.exception.MailingException;
import com.nick.hateportal.validation.LoginFormValidator;
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
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/log")
public class LoginController extends ExceptionsController {

    @Autowired
    private LoginFormValidator validator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showLoginFrom(HttpServletRequest request , HttpServletResponse response, HttpSession session, Model model){

        if (SessionCheckLogin.checkLoggedInEither(session)){
            session.removeAttribute("auth");
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("auth")){
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
                session.setAttribute("auth", new SpringConverterUserToUserDTO().convert(userFromDB));
                Cookie cookie = new Cookie("auth","1");
                cookie.setMaxAge(7);
                cookie.setPath("/");
                cookie.setSecure(false);
                cookie.setHttpOnly(true);

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
    public String vkLogin(){
        String codeHttp= Vk.getCodeHttp();
        return "redirect:" + codeHttp;
    }

    @RequestMapping(value = "/log.access")
    public String loginFinalVk(HttpServletRequest request, HttpSession session){
        String code = request.getParameter("code");
        HashMap<String,String> userInfo= Vk.finalHttp(code);
        if (userInfo!=null){
            String email = userInfo.get("email");
            User userFromDB = userService.getUserByEmail(email);
            session.removeAttribute("auth");

            if (userFromDB!=null){
                session.setAttribute("auth", new SpringConverterUserToUserDTO().convert(userFromDB));
                return "redirect:/";
            }else {
                String passForEmail = userService.createDefaultUser(userInfo.get("first_name"),userInfo.get("last_name"),email);
                try {
                    userService.sendEmailToNewVkUser(email, passForEmail);
                } catch (MailingException e) {
                    e.printStackTrace();
                }
                User user = userService.getUserByEmail(email);
                session.setAttribute("auth", new SpringConverterUserToUserDTO().convert(user));
            }
        }
        return "redirect:/";
    }
}
