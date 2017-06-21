package com.nick.hateportal.utils.admin;


import com.nick.hateportal.comparators.user.UserIdAscComparator;
import com.nick.hateportal.comparators.user.UserRateAscComparator;
import com.nick.hateportal.entity.User;
import com.nick.hateportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminListHandlerUser {
    @Autowired
    private UserService userService;

    @Autowired
    private UserIdAscComparator userIdAscComparator;

    @Autowired
    private UserRateAscComparator userRateAscComparator;

    public List<User> listUserSortBy(ListAdminUserSortPossibilities sortType) {
      List<User> list = userService.getAllUsersAscId();
          switch (sortType){
                case SORT_USER_ID_DOWN:
//                    list.sort(userIdAscComparator);
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
        return list;
    }
}

