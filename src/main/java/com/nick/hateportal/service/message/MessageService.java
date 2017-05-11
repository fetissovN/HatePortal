package com.nick.hateportal.service.message;


import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;

import java.util.List;

public interface MessageService {

    void saveMessage(Message message);

    void deleteMessage(Message message);

    void uptadeMessage(Message message);

    List<Message> getAllMessagesByPostId(Post post);

}
