package com.nick.hateportal.controllers;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.comparators.UserAscComparator;
import com.nick.hateportal.comparators.UserDescComparator;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import com.nick.hateportal.utils.admin.AdminListHandler;
import com.nick.hateportal.utils.admin.ListUserSortPossibilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAscComparator userAscComparator;

    @Autowired
    private UserDescComparator userDescComparator;

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
            List<User> list = adminListHandler.listUserSortBy(session, ListUserSortPossibilities.SORT_USER_ID_UP);
            model.addAttribute("countUsers", list.size());
            model.addAttribute("list", list);
            return "admin";
        }else {
            return "home";
        }

    }

    @RequestMapping(value = "")
    public String showUsersAsc(@RequestParam(value = "n") int n,HttpSession session, Model model){

        UserDTO userDTO = (UserDTO) session.getAttribute("auth");

        if (userDTO.getRole()==0){
            List<User> list = adminListHandler.listUserSortBy(session, ListUserSortPossibilities.);
            model.addAttribute("list", list);
            return "admin";
        }else {
            return "home";
        }
    }

}
