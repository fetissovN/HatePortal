package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class BarController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/infoCh")
    @ResponseBody
    public String saveChanges(@ModelAttribute("barUserInfo") UserDTO userDTO, Model model, HttpSession session, BindingResult result){
//        System.out.println(userDTO.getEmail());
        if (userService.getUserByEmail(userDTO.getEmail())!=null){
            UserDTO userSession = (UserDTO) session.getAttribute("auth");
            System.out.println(userDTO.getId());
//            user.setId(userDTO.getId());
//            user.setRate(userDTO.getRate());
//            user.setRole(userDTO.getRole());
            userService.updateUser(userDTO);
            session.invalidate();
            session.setAttribute("auth", userDTO);
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping(value = "/showInfo", method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session){
        if (session.getAttribute("auth")==null){
            return "redirect:/log/";
        }
        model.addAttribute("barUserInfo", new UserDTO());
//        System.out.println(s);
        return "infoFrom";
    }
}
