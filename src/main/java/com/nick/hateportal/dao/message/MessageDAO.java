package com.nick.hateportal.dao.message;


import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;

import java.util.List;

public interface MessageDAO {

    Message getMessageById(Long id);

    void saveMessage(Message message);

    void deleteMessage(Message message);

    void updateMessage(Message message);

    List<Message> getAllMessagesByPostId(Post post);


}
