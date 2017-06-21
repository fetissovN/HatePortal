package com.nick.hateportal.utils.login;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.SpringConverterUserDTOToUser;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class SessionCheckUserInfo {

    @Autowired
    @Qualifier(value = "springConverterUserDTOToUser")
    private static SpringConverterUserDTOToUser converterUserDTOToUser;

    public static boolean checkUserRelatedToPost(Long id, User user){
        List<Post> list = user.getSentPosts();
        for (Post p: list){
            if (p.getId()==id){
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserRelatedToPost(Long id, HttpSession session){
        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
//        SpringConverterUserDTOToUser springConverterUserDTOToUser = new SpringConverterUserDTOToUser();
        User user = converterUserDTOToUser.convert(userDTO);
//        User user = SpringConverterUserDTOToUser.convert(userDTO);

        List<Post> list = user.getSentPosts();
        for (Post p: list){
            if (p.getId()==id){
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserRelatedToMessage(Long messageId, Long postId, User user){
        if (checkUserRelatedToPost(postId,user)){
            Post post = user.getSentPosts().get(Math.toIntExact(postId)-1);
            List<Message> messages = post.getPostRelatedMessages();
            for (Message m: messages){
                if (m.getId()==messageId){
                    return true;
                }
            }
            return false;
        }else {
            return false;
        }
    }
}
