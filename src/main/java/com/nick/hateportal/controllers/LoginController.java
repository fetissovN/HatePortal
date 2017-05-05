package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.validation.LoginFormValidator;
import com.nick.hateportal.validation.RegFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/log")
public class LoginController {

    @Autowired
    private LoginFormValidator validator;

    @RequestMapping(value = "/")
    public String showLoginFrom(Model model){
        model.addAttribute("loginForm", new UserLoginDTO());
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute(value = "loginForm") UserLoginDTO loginDTO, HttpSession session, Model model, BindingResult result){
        validator.validate(loginDTO, result);
        if (result.hasErrors()){
//            model.addAttribute("loginFrom", new UserLoginDTO());
            return "login";
        }

        return "login";
    }
}
