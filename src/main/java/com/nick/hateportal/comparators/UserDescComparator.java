package com.nick.hateportal.comparators;

import com.nick.hateportal.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class UserDescComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
