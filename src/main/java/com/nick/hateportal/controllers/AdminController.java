package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/")
    public String showStartScreen(Model model, HttpSession session){

        UserDTO userDTO = (UserDTO) session.getAttribute("auth");

        if (userDTO.getRole()==0){
            List<User> list = userService.getAllUsers();
            model.addAttribute("list", list);
            return "admin";
        }else {
            return "home";
        }

    }
}
