package com.nick.hateportal.comparators.post;

import com.nick.hateportal.entity.Post;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Date;

@Component
public class PostDateAscComparator<T extends Post> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Date o1Date = o1.getPostDate();
        Date o2Date = o2.getPostDate();
        if (o1Date!=null || o2Date!=null){
            if (o1Date.before(o2Date)){
                return -1;
            } else if (o1Date.after(o2Date)){
                return 1;
            } else {
                return 0;
            }
        }else {
            return -1;
        }
    }
}
