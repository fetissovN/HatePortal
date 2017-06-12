package com.nick.hateportal.comparators;

import com.nick.hateportal.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class UserAscComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
