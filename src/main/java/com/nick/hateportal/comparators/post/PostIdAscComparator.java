package com.nick.hateportal.comparators.post;


import com.nick.hateportal.entity.Post;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class PostIdAscComparator<T extends Post> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
