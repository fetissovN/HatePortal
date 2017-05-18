package com.nick.hateportal.controllers;

import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.post.PostService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/")
    public String redirectToHome(HttpSession session, Model model ){
        List<Post> list = postService.getAllPosts();
        model.addAttribute("posts", list);
        model.addAttribute("postForm", new Post());
        model.addAttribute("barUserInfo", new User());
        if (session.getAttribute("auth")==null){

            model.addAttribute("role","0");
        }else {
            if (session.getAttribute("auth").getClass().getName().equals("User")){
                User user = (User) session.getAttribute("auth");
                model.addAttribute("user", user);
                return "home";
            }
        }
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


//    @RequestMapping(value = "/po")
}
