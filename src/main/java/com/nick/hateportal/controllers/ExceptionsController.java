package com.nick.hateportal.controllers;

import com.nick.hateportal.utils.exception.MailingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@ControllerAdvice
public abstract class ExceptionsController {

    @ExceptionHandler(Exception.class)
    public String handleIOException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "/error/exceptionpage";
    }

    @ExceptionHandler(MailingException.class)
    @ResponseBody
    public String handleMailException(){
        String error = "Problem occur, check your internet connection!";
        return error;
    }

}
