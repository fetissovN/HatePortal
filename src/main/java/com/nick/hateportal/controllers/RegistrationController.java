package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserRegDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

    @RequestMapping(value = "/")
    public String showRegPage(Model model){
        model.addAttribute("regForm", new UserRegDTO());
        return "register";
    }

    @RequestMapping(value = "/do.reg")
    public String register(@ModelAttribute("regForm") UserRegDTO userRegDTO, BindingResult result){

        return "/log/";
    }
}
