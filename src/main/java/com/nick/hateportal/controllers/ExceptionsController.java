package com.nick.hateportal.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 *  Created by ZheynovVV on 01.10.2016.
 */

@EnableWebMvc
@ControllerAdvice
public abstract class ExceptionsController {

    @ExceptionHandler(Exception.class)
    public String handleIOException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "/error/exceptionpage";
    }

}
