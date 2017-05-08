package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.PassHash;
import com.nick.hateportal.validation.RegFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping(value = "/reg")
public class RegistrationController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RegFormValidator validator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showRegPage(Model model){
        model.addAttribute("regForm", new UserRegDTO());
        return "register";
    }

    @RequestMapping(value = "/do.reg")
    public String register(@ModelAttribute("regForm") UserRegDTO userRegDTO,Model model, BindingResult result){
        validator.validate(userRegDTO, result);
        if (result.hasErrors()){
            return "register";
        }
        User userFromDB = userService.getUserByEmail(userRegDTO.getEmail());
        if (userFromDB==null){
            try{
                PassHash passHash = new PassHash();
                String pass = passHash.stringPassToHash(userRegDTO.getPassword());
                User user = new User();
                user.setEmail(userRegDTO.getEmail());
                user.setPassword(pass);
                user.setPhone(userRegDTO.getPhone());
                user.setRate(0.0);
                user.setUsername(userRegDTO.getUsername());
                user.setSurname(userRegDTO.getSurname());
                user.setRole(1);
                userService.createUser(user);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            model.addAttribute("regForm", new UserRegDTO());
            model.addAttribute("userExist", "Exist");
            return "register";
        }

        return "redirect:/log/";
    }
}
