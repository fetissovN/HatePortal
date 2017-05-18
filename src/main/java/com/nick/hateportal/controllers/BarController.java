package com.nick.hateportal.controllers;

import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class BarController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/infoCh")
    public String saveChanges(@ModelAttribute("barUserInfo") User user, Model model, HttpSession session, BindingResult result){
        if (userService.getUserByEmail(user.getEmail())!=null){
            userService.updateUser(user);
            session.invalidate();
            session.setAttribute("auth", user);
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping(value = "/showInfo", method = RequestMethod.GET)
    public String showInfo(Model model){
        model.addAttribute("barUserInfo", new User());
//        System.out.println(s);
        return "infoFrom";
    }
}
