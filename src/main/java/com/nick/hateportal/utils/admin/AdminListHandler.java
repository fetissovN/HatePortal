package com.nick.hateportal.utils.admin;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.comparators.UserAscComparator;
import com.nick.hateportal.comparators.UserDescComparator;
import com.nick.hateportal.comparators.UserRateAscComparator;
import com.nick.hateportal.comparators.UserRateDescComparator;
import com.nick.hateportal.entity.User;
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
    private UserAscComparator userAscComparator;

    @Autowired
    private UserDescComparator userDescComparator;

    @Autowired
    private UserRateAscComparator userRateAscComparator;

    @Autowired
    private UserRateDescComparator userRateDescComparator;

    public List<User> listUserSortBy(HttpSession session, ListUserSortPossibilities sortType) {
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
                    list.sort(userAscComparator);
                    break;
                case SORT_USER_ID_UP:
                    list.sort(userDescComparator);
                    break;
                case SORT_USER_RATE_DOWN:
                    list.sort(userRateAscComparator);
                    break;
                case SORT_USER_RATE_UP:
                    list.sort(userRateDescComparator);
                    break;

                default:
                    list.sort(userDescComparator);
                    break;
            }
        }
        return list;
    }
}
