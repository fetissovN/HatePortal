package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.post.PostService;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.validation.MessageFormValidator;
import com.nick.hateportal.validation.PostFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostFormValidator postFormValidator;

    @Autowired
    private MessageFormValidator messgeFormValidator;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showForm(Model model, HttpSession session){
        if (session.getAttribute("auth")==null){
            return "redirect:/log/";
        }
        model.addAttribute("postForm", new Post());
        return "home";
    }

    @RequestMapping(value = "/create")
    public String createPost(@ModelAttribute(value = "postForm") Post post, Model model, HttpSession session, BindingResult result){
        postFormValidator.validate(post, result);
        if (result.hasErrors()){
            return "home";
        }
        Date date = new Date();
        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        User user = userService.getUserByEmail(userDTO.getEmail());
        post.setPostDate(new java.sql.Date(date.getTime()));
        post.setUserId(user);
        postService.createPost(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/post/{id}")
    public String showPostById(@PathVariable("id") Long id, Model model){
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("messagePost", new Message());
        return "post";
    }

    @RequestMapping(value = "/comment/{post}")
    public String getComments(@PathVariable("post") Post post, @ModelAttribute(value = "messagePost") Message message, Model model, BindingResult result ){
        messgeFormValidator.validate(message, result);
        if (result.hasErrors()){
//            Post post = new Post();
//            post.getClass()
            model.addAttribute("post", post);

            return "post";
        }
        return "post";
    }

}
