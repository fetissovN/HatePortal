package com.nick.hateportal.controllers;

import com.nick.hateportal.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String redirectToHome(HttpSession session, Model model ){

        if (session.getAttribute("auth")==null){

            model.addAttribute("role","0");
        }else {
            if (session.getAttribute("auth").getClass().getName().equals("User")){
                User user = (User) session.getAttribute("auth");
                model.addAttribute("user", user);
                return "home";
            }
        }
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
