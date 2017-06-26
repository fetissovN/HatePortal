package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.admin.*;
import com.nick.hateportal.utils.login.SessionCheckLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminListHandlerUser adminListHandlerUser;

    @Autowired
    private AdminListHandlerPost adminListHandlerPost;

    @RequestMapping(value = "/reload")
    public String reload(HttpSession session){
        session.removeAttribute("listUsers");
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/")
    public String showStartScreen(Model model, HttpSession session){

        if (SessionCheckLogin.checkLoggedInAdmin(session)) {
            List<User> listUsers = adminListHandlerUser.listUserSortBy(ListAdminUserSortPossibilities.SORT_USER_ID_UP);
            List<Post> listPosts = adminListHandlerPost.adminPostSortBy(ListAdminPostSortPossibilities.SORT_POST_ID_UP,-1);

            model.addAttribute("countUsers", listUsers.size());
            model.addAttribute("countPosts", listPosts.size());

            model.addAttribute("list", listUsers);
            model.addAttribute("listPosts", listPosts);
            return "admin";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "",params = "n")
    public String showUsersAsc(@RequestParam(value = "n") int n ,HttpSession session, Model model){

        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            List<User> list = adminListHandlerUser.listUserSortBy(ListAdminUserSortPossibilities.getMask(n));
            model.addAttribute("countUsers", list.size());
            model.addAttribute("list", list);
            return "formSample/admin/users";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "",params = "p")
    public String showPostsAsc(@RequestParam(value = "p") int p ,HttpSession session, Model model){

        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            List<Post> list = adminListHandlerPost.adminPostSortBy(ListAdminPostSortPossibilities.getMask(p),-1);
            model.addAttribute("countPosts", list.size());
            model.addAttribute("listPosts", list);
            return "formSample/admin/posts";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "",params = {"p","user"})
    public String showPostsAsc(@RequestParam(value = "p") int p ,@RequestParam(value = "user") int userId,HttpSession session, Model model){
        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            int userIdSort = -1;
            if (userId>=0){
                userIdSort=userId;
            }
            List<Post> list = adminListHandlerPost.adminPostSortBy(ListAdminPostSortPossibilities.getMask(p),userIdSort);
            model.addAttribute("countPosts", list.size());
            model.addAttribute("listPosts", list);
            model.addAttribute("postOfUser","true");
            return "formSample/admin/posts";
        }else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/userPosts{idUser}")
    public String showUserPosts(@PathVariable(value = "idUser") Long id, HttpSession session, Model model){
        if (SessionCheckLogin.checkLoggedInAdmin(session)){
            List<Post> list = adminListHandlerPost.userPosts(id);
            model.addAttribute("countPosts", list.size());
            model.addAttribute("listPosts", list);
            if (list.size()==0){
                model.addAttribute("postOfUser","false");
            }else {
                model.addAttribute("postOfUser","true");
            }
            return "formSample/admin/posts";
        }else {
            return "redirect:/";
        }
    }

}
