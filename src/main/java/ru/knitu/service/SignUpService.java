package ru.knitu.service;


import ru.knitu.form.UserForm;


public interface SignUpService {
    public void signUp(UserForm userForm, String resultFileName);
}
