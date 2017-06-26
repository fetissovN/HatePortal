package com.nick.hateportal.utils.login;

import com.nick.hateportal.DTO.UserDTO;
import com.nick.hateportal.converter.SpringConverterUserDTOToUser;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import com.nick.hateportal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class SessionCheckUserInfo {

    @Autowired
    private SpringConverterUserDTOToUser converterUserDTOToUser;

    private boolean checkUserRelatedToPost(Long id, User user){
        List<Post> list = user.getSentPosts();
        for (Post p: list){
            if (p.getId()==id){
                return true;
            }
        }
        return false;
    }

    private User getUserFromSession(HttpSession session){
        UserDTO userDTO = (UserDTO) session.getAttribute("auth");
        return converterUserDTOToUser.convert(userDTO);
    }

    public boolean checkUserRelatedToPost(Long id, HttpSession session){
        User user = getUserFromSession(session);
        return checkUserRelatedToPost(id,user);
    }

    public boolean checkUserRelatedToMessage(Long messageId, Long postId, HttpSession session){
        User user = getUserFromSession(session);
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
