package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.utils.admin.AdminListHandler;
import com.nick.hateportal.utils.admin.ListAdminPostSortPossibilities;
import com.nick.hateportal.utils.admin.ListAdminUserSortPossibilities;
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
    private AdminListHandler adminListHandler;

    @RequestMapping(value = "/reload")
    public String reload(HttpSession session){
        session.removeAttribute("listUsers");
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/")
    public String showStartScreen(Model model, HttpSession session){
        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        if (userDTO.getRole() == 0) {
            List<User> listUsers = adminListHandler.listUserSortBy(session, ListAdminUserSortPossibilities.SORT_USER_ID_UP);
            List<Post> listPosts = adminListHandler.adminPostSortBy(session, ListAdminPostSortPossibilities.SORT_POST_ID_UP);
            model.addAttribute("countUsers", listUsers.size());
            model.addAttribute("countPosts", listPosts.size());

            model.addAttribute("list", listUsers);
            model.addAttribute("listPosts", listPosts);
            return "admin";
        }else {
            return "home";
        }

    }

    @RequestMapping(value = "",params = "n")
    public String showUsersAsc(@RequestParam(value = "n") int n ,HttpSession session, Model model){

        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        if (userDTO.getRole()==0){
            List<User> list = adminListHandler.listUserSortBy(session, ListAdminUserSortPossibilities.getMask(n));
            model.addAttribute("countUsers", list.size());
            model.addAttribute("list", list);
            return "admin";
        }else {
            return "home";
        }
    }

    @RequestMapping(value = "",params = "p")
    public String showPostsAsc(@RequestParam(value = "p") int p ,HttpSession session, Model model){

        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        if (userDTO.getRole()==0){
            List<User> listUser = (List<User>) session.getAttribute("listUsers");

            List<Post> list = adminListHandler.adminPostSortBy(session, ListAdminPostSortPossibilities.getMask(p));

            model.addAttribute("countPosts", list.size());
            model.addAttribute("countUsers", listUser.size());
            model.addAttribute("listPosts", list);
            model.addAttribute("list", listUser);
            return "admin";
        }else {
            return "home";
        }
    }

    @RequestMapping(value = "/userPosts{idUser}")
    public String showUserPosts(@PathVariable(value = "idUser") Long id, HttpSession session, Model model){
        List<User> listUser = (List<User>) session.getAttribute("listUsers");

        List<Post> list = adminListHandler.userPosts(session, id);
        model.addAttribute("countPosts", list.size());
        model.addAttribute("countUsers", listUser.size());
        model.addAttribute("listPosts", list);
        model.addAttribute("list", listUser);
        return "admin";
    }

}
