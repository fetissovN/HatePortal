package com.nick.hateportal.comparators;

import com.nick.hateportal.entity.User;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class UserDescComparator<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o2.getId().compareTo(o1.getId());
    }


}
