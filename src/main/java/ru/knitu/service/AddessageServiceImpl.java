package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.model.Message;
import ru.knitu.model.User;
import ru.knitu.repo.MessageRepository;

import java.util.Date;

@Service
public class AddessageServiceImpl implements AddessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void addMessage(String message, User from, User to) {
        Message messageModel = Message.builder()
                .text(message)
                .fromUser(from)
                .toUser(to)
                .date(new Date())
        .build();

        messageRepository.save(messageModel);
    }
}
