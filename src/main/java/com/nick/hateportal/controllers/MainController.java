package com.nick.hateportal.controllers;

import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController extends ExceptionsController{

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/")
    public String redirectToHome(HttpSession session, Model model ){
        List<Post> list = postService.getStartPosts(5);
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

    @RequestMapping(value = "/loadPosts",method = RequestMethod.GET)
    public String loadPosts(Model model, @RequestParam("page") String page){
        List<Post> loadedPosts = postService.getFivePostsDB(Integer.parseInt(page));
        model.addAttribute("posts",loadedPosts);
        model.addAttribute("page", page);
        return "formSample/mainPostsAjax";
    }
}
