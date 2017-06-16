package com.nick.hateportal.utils.admin;

import com.nick.hateportal.comparators.post.PostDateAscComparator;
import com.nick.hateportal.comparators.post.PostIdAscComparator;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminListHandlerPost {

    @Autowired
    private PostService postService;

    @Autowired
    private PostIdAscComparator postIdAscComparator;

    @Autowired
    private PostDateAscComparator postDateAscComparator;

        public List<Post> adminPostSortBy(ListAdminPostSortPossibilities sortType){
        List<Post> list = postService.getAllPosts();

        switch (sortType){
            case SORT_POST_ID_DOWN:
                list.sort(postIdAscComparator);
                break;
            case SORT_POST_ID_UP:
                list.sort(postIdAscComparator.reversed());
                break;
            case SORT_POST_DATE_DOWN:
                list.sort(postDateAscComparator);
                break;
            case SORT_POST_DATE_UP:
                list.sort(postDateAscComparator.reversed());
                break;

            default:
                list.sort(postIdAscComparator);
                break;
        }
        return list;

    }

    public List<Post> userPosts(Long id){
        List<Post> list = postService.getAllPosts();
        List<Post> newList = new ArrayList<>();
        for (Post l: list ){
            if (l.getUserId().getId()==id){
                newList.add(l);
            }
        }
        return newList;
    }
}
