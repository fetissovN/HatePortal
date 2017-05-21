package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.validation.AccountInfoFormValidator;
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
    private AccountInfoFormValidator validator;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/infoCh")
    public String saveChanges(@ModelAttribute("barUserInfo") User user, Model model, HttpSession session, BindingResult result){
        validator.validate(user,result);
        if (result.hasErrors()){
            return "formSample/infoFrom";
        }
        if (userService.getUserByEmail(user.getEmail())!=null){
            UserDTO userDTO = (UserDTO) session.getAttribute("auth");
            System.out.println(userDTO);
            user.setId(userDTO.getId());
            user.setRate(userDTO.getRate());
            user.setRole(userDTO.getRole());
            userService.updateUser(user);
            session.removeAttribute("auth");
            session.setAttribute("auth", DTOConverter.convertUserToUserDto(user));
            return null;
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/showInfo", method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session){
        if (session.getAttribute("auth")==null){
//            model.addAttribute("auth", "1");
            return null;
        }else {
            model.addAttribute("barUserInfo", new User());
            return "formSample/infoFrom";
        }

    }
}
