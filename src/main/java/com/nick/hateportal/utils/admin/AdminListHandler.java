package com.nick.hateportal.utils.admin;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.comparators.post.PostDateAscComparator;
import com.nick.hateportal.comparators.post.PostIdAscComparator;
import com.nick.hateportal.comparators.user.UserIdAscComparator;
import com.nick.hateportal.comparators.user.UserRateAscComparator;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.post.PostService;
import com.nick.hateportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminListHandler {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserIdAscComparator userIdAscComparator;

    @Autowired
    private UserRateAscComparator userRateAscComparator;

    @Autowired
    private PostIdAscComparator postIdAscComparator;

    @Autowired
    private PostDateAscComparator postDateAscComparator;

    public List<User> listUserSortBy(HttpSession session, ListAdminUserSortPossibilities sortType) {
        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        List<User> list = new ArrayList<>();
        if (userDTO.getRole() == 0) {

            if (session.getAttribute("listUsers") == null) {
                list = userService.getAllUsersDescId();
                session.setAttribute("listUsers", list);
            } else {
                list = (List<User>) session.getAttribute("listUsers");
            }
            switch (sortType){
                case SORT_USER_ID_DOWN:
                    list.sort(userIdAscComparator);
                    break;
                case SORT_USER_ID_UP:
                    list.sort(userIdAscComparator.reversed());
                    break;
                case SORT_USER_RATE_DOWN:
                    list.sort(userRateAscComparator);
                    break;
                case SORT_USER_RATE_UP:
                    list.sort(userRateAscComparator.reversed());
                    break;

                default:
                    list.sort(userIdAscComparator);
                    break;
            }
        }
        return list;
    }

    public List<Post> adminPostSortBy(HttpSession session, ListAdminPostSortPossibilities sortType){
        List<Post> list = new ArrayList<>();
        if (session.getAttribute("listPosts") == null) {
            list = postService.getAllPosts();
            session.setAttribute("listPosts", list);
        } else {
            list = (List<Post>) session.getAttribute("listPosts");
        }
        switch (sortType){
            case SORT_POST_ID_DOWN:
                list.sort(postIdAscComparator);
                break;
            case SORT_POST_ID_UP:
                list.sort(postIdAscComparator.reversed());
                break;
            case SORT_POST_DATE_DOWN:
                list.sort(postDateAscComparator);
                break;
            case SORT_POST_DATE_UP:
                list.sort(postDateAscComparator.reversed());
                break;

            default:
                list.sort(postIdAscComparator);
                break;
        }
        return list;

    }

    public List<Post> userPosts(HttpSession session, Long id){
        List<Post> list = postService.getAllPosts();
//        List<Post> list = (List<Post>) session.getAttribute("listPosts");
        List<Post> newList = new ArrayList<>();
        for (Post l: list ){
            if (l.getUserId().getId()==id){
                newList.add(l);
            }
        }
        session.removeAttribute("listPosts");
        session.setAttribute("listPosts", newList);
        return newList;
    }
}
