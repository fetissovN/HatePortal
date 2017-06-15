package com.nick.hateportal.comparators.user;

import com.nick.hateportal.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class UserRateDescComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getRate().compareTo(o1.getRate());
    }


}
