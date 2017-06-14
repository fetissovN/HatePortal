package com.nick.hateportal.comparators.forUser;

import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class UserIdAscComparator<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
