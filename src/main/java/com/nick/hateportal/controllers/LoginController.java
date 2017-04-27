package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.DTO.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/log")
public class LoginController {

    @RequestMapping(value = "/")
    public String showLoginFrom(Model model){
        model.addAttribute("loginForm", new UserLoginDTO());
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession session, Model model, @ModelAttribute("loginFrom")UserLoginDTO loginDTO, BindingResult result){


        return "login";
    }
}
