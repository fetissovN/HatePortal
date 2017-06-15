package com.nick.hateportal.comparators.post;

import com.nick.hateportal.entity.Post;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class PostDateAscComparator<T extends Post> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getPostDate().before(o2.getPostDate())){
            return -1;
        } else if (o1.getPostDate().after(o2.getPostDate())){
            return 1;
        } else {
            return 0;
        }
    }
}
