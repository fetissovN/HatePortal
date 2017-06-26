package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserRegDTO;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.login.ConvertNewUserRegDtoToUser;
import com.nick.hateportal.utils.password.PassHash;
import com.nick.hateportal.validation.RegFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/reg")
public class RegistrationController extends ExceptionsController {

    @Autowired
    private RegFormValidator validator;

    @Autowired
    private UserService userService;

    @Autowired
    private ConvertNewUserRegDtoToUser convertNewUserRegDtoToUser;

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
                userRegDTO.setPassword(pass);
                User user = convertNewUserRegDtoToUser.convert(userRegDTO);
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
