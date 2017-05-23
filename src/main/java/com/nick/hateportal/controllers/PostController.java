package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.message.MessageService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private MessageService messageService;

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
            List<Post> list = postService.getAllPosts();
            model.addAttribute("posts", list);
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

        List<Message> messages = messageService.getAllMessagesByPostId(post);
        model.addAttribute("messages", messages);
        return "post";
    }

    @RequestMapping(value = "/post/comment/{id}")
    public String getComments(@PathVariable("id") Long id,HttpSession session, @ModelAttribute(value = "messagePost") Message message, Model model, BindingResult result ){
        if (session.getAttribute("auth")==null){
            return "redirect:/log/";
        }
        messgeFormValidator.validate(message, result);
        Post post = postService.getPostById(id);
        if (result.hasErrors()){
            List<Message> messages = messageService.getAllMessagesByPostId(post);
            model.addAttribute("messages", messages);
            model.addAttribute("post", post);
            return "/post";
        }

        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        Date date = new Date();
        User user = userService.getUserByEmail(userDTO.getEmail());

        message.setMessage_date(new java.sql.Date(date.getTime()));
        message.setPost_id(post);
        message.setUser_id(user);
        messageService.saveMessage(message);
        model.addAttribute("post", post);
        List<Message> messages = messageService.getAllMessagesByPostId(post);
        model.addAttribute("messages", messages);
        return "/post";
    }

    @RequestMapping(value = "/like/{postId}")
    public @ResponseBody String likePost(@PathVariable("postId") Long id){
        postService.likePost(id);
        return "1";
    }

}
