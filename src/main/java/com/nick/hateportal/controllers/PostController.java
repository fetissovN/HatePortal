package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.SpringConverterUserDTOToUser;
import com.nick.hateportal.converter.SpringConverterUserToUserDTO;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.message.MessageService;
import com.nick.hateportal.service.post.PostService;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.login.SessionCheckLogin;
import com.nick.hateportal.utils.login.SessionCheckUserInfo;
import com.nick.hateportal.validation.MessageFormValidator;
import com.nick.hateportal.validation.PostFormValidator;
import javafx.geometry.Pos;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController extends ExceptionsController {

    @Autowired
    private PostFormValidator postFormValidator;

    @Autowired
    private MessageFormValidator messageFormValidator;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SpringConverterUserDTOToUser converterUserDTOToUser;

    @Autowired
    private SessionCheckUserInfo sessionCheckUserInfo;

    @RequestMapping(value = "/")
    public String showForm(Model model, HttpSession session){
        if (!SessionCheckLogin.checkLoggedInEither(session)){
            return "redirect:/log/";
        }
        model.addAttribute("postForm", new Post());
        return "home";
    }

    @RequestMapping(value = "/create")
    public String createPost(@ModelAttribute(value = "postForm") Post post, Model model, HttpSession session, BindingResult result){
        if (SessionCheckLogin.checkLoggedInUser(session)){
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
        }else {
            return "redirect:/log/";
        }

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
        messageFormValidator.validate(message, result);
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

    @RequestMapping(value = "/message/like/{messId}")
    public @ResponseBody String likeMessage(@PathVariable("messId") Long id){
        messageService.markLike(id);
        return "1";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, HttpSession session){
        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            postService.deletePost(id);
            return "redirect:/";
        }else if (SessionCheckLogin.checkLoggedInUser(session)){
//            UserDTO userDTO = (UserDTO) session.getAttribute("auth");
//            User user = converterUserDTOToUser.convert(userDTO);
            if (SessionCheckUserInfo.checkUserRelatedToPost(id,session)){
                postService.deletePost(id);
            }
            return "redirect:/";
        }else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/message/delete/{messageId}/{postId}")
    public String deleteMessage(HttpSession session, @PathVariable("messageId") Long messageId, @PathVariable("postId") Long postId){
        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            messageService.deleteMessage(messageId);
            String post = String.valueOf(postId);
            return "redirect:/post/post/" + post;
        }else if (SessionCheckLogin.checkLoggedInUser(session)){
            UserDTO userDTO = (UserDTO) session.getAttribute("auth");
            User user = converterUserDTOToUser.convert(userDTO);
            if (SessionCheckUserInfo.checkUserRelatedToMessage(messageId,postId,user)){
                messageService.deleteMessage(messageId);
                String post = String.valueOf(postId);
                return "redirect:/post/post/" + post;
            }else {
                return "redirect:/";
            }
        }else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/updateShow/{postId}", method = RequestMethod.GET)
    public String showUpdatePostFrom(@PathVariable("postId") Long postId, Model model, HttpSession session){

        if (SessionCheckLogin.checkLoggedInEither(session)){
            Post post = postService.getPostById(postId);
            model.addAttribute("postForm", post);
            return "formSample/postForm";
        }else if (SessionCheckUserInfo.checkUserRelatedToPost(postId,session)){
            Post post = postService.getPostById(postId);
            model.addAttribute("postForm", post);
            return "formSample/postForm";
        }else {
            return "redirect:/log/";
        }

    }

    @RequestMapping(value = "/update/{postId}", method = RequestMethod.POST)
    public String updatePost(@ModelAttribute(value = "postForm") Post post,
                                           @PathVariable("postId") Long id, BindingResult result){
        postFormValidator.validate(post,result);
        if (result.hasErrors()){
            return "formSample/postForm";
        }
        postService.updatePost(post,id);
        return "redirect:/info_save_ok" + id;
    }

    @RequestMapping(value = "/message/updateShow/{messageId}")
    public String updateMessageShow(Model model, @PathVariable("messageId") Long messageId){
        Message message = messageService.getMessageById(messageId);
        model.addAttribute("messageUpdate", message);
        return "formSample/messageUpdate";
    }

    @RequestMapping(value = "/comment/update",method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public @ResponseBody String updateMessage(@ModelAttribute(value = "messageUpdate") Message message,
                                              HttpSession session){

        messageService.updateMessage(message, message.getId());
        JSONObject object = new JSONObject();
        object.put("id", message.getId());
        object.put("message", message.getMessage());
        return object.toString();
    }
}
