package com.nick.hateportal.service.message;

import com.nick.hateportal.dao.message.MessageDAO;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public void saveMessage(Message message) {
        messageDAO.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
        Message message = messageDAO.getMessageById(id);
        messageDAO.deleteMessage(message);
    }

    @Override
    public void markLike(Long id) {
        Message message = messageDAO.getMessageById(id);
        int count = message.getLike();
        message.setLike(count+1);
        messageDAO.updateMessage(message);
    }

    @Override
    public List<Message> getAllMessagesByPostId(Post post) {
        return messageDAO.getAllMessagesByPostId(post);
    }
}
