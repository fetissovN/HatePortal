package com.nick.hateportal.controllers;

import com.nick.hateportal.entity.Post;
import com.nick.hateportal.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/")
    public String showForm(Model model, HttpSession session){
        model.addAttribute("postForm", new Post());
        return "home";
    }

    @RequestMapping(value = "/create")
    public String createPost(){
        return "home";
    }
}
