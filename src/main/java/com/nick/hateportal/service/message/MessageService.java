package com.nick.hateportal.service.message;


import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;

import java.util.List;

public interface MessageService {

    Message getMessageById(Long id);

    void saveMessage(Message message);

    void deleteMessage(Long id);

    void markLike(Long id);

    List<Message> getAllMessagesByPostId(Post post);

    void updateMessage(Message message, Long messageId);
}
