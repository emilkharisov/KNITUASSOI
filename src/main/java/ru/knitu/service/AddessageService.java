package ru.knitu.service;

import ru.knitu.model.User;

public interface AddessageService {

    void addMessage(String message,  User from, User to);

}
