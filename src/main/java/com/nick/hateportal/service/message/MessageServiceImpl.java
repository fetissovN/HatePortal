package com.nick.hateportal.service.message;

import com.nick.hateportal.dao.message.MessageDAO;
import com.nick.hateportal.entity.Message;
import com.nick.hateportal.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteMessage(Message message) {

    }

    @Override
    public void uptadeMessage(Message message) {

    }

    @Override
    public List<Message> getAllMessagesByPostId(Post post) {
        return messageDAO.getAllMessagesByPostId(post);
    }
}
