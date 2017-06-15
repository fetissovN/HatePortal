package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.FeedbackDTO;
import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.DTOConverter;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.Mailing;
import com.nick.hateportal.utils.exception.MailingException;
import com.nick.hateportal.validation.AccountInfoFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BarController extends ExceptionsController {

    @Autowired
    private AccountInfoFormValidator validator;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/infoCh", method = RequestMethod.POST)
    public String saveChanges(@ModelAttribute("barUserInfo") User user, HttpSession session, BindingResult result){
        validator.validate(user,result);
        if (result.hasErrors()){
            return "formSample/infoFrom";
        }
        User userDb = userService.getUserByEmail(user.getEmail());
        if (userService.getUserByEmail(user.getEmail())!=null){
//            UserDTO userDTO = (UserDTO) session.getAttribute("auth");
            user.setId(userDb.getId());
            user.setRate(userDb.getRate());
            user.setRole(userDb.getRole());
            userService.updateUser(user);
            session.removeAttribute("auth");
            session.setAttribute("auth", DTOConverter.convertUserToUserDto(user));
            return "redirect:/info_save_ok1";
        }else {
            return "redirect:/info_save_ok0";
        }
    }

    @RequestMapping(value = "/info_save_ok{status}")
    public @ResponseBody String saved(@PathVariable("status") String status){
        return status;
    }

    @RequestMapping(value = "/showInfo", method = RequestMethod.GET)
    public String showInfo(Model model, HttpServletRequest request, HttpSession session){
        Cookie[] cookies = request.getCookies();
        for (int i=0;i<cookies.length;i++){
            if (cookies[i].getValue().equals("1")){
                model.addAttribute("barUserInfo", new User());
                return "formSample/infoFrom";
            }
        }
        if (session.getAttribute("auth")==null){
//            model.addAttribute("auth", "1");
            return null;
        }else {
            model.addAttribute("barUserInfo", new User());
            return "formSample/infoFrom";
        }

    }

    @RequestMapping(value = "/showFeedback", method = RequestMethod.GET)
    public String showFeedback(Model model){
        model.addAttribute("barFeedback", new FeedbackDTO());
        return "formSample/feedbackFrom";
    }

    @RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
    @ResponseBody
    public String sendFeedback(@ModelAttribute("barFeedback") FeedbackDTO feedbackDTO) throws MailingException{
            Mailing mailing = new Mailing();
        try {
            mailing.send("test",feedbackDTO.getFeedback(),"asd",feedbackDTO.getEmail());
        } catch (MailingException e) {

            throw new MailingException("nnn");
//            e.printStackTrace();
        }
        return "1";
    }
}
