package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;

@Service
public class SignUpServiceImpl implements  SignUpService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm, String resultFileName) {
        String hashpassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                                    .login(userForm.getLogin())
                                    .hashpassword(hashpassword)
                                    .firstname(userForm.getFirstname())
                                    .lastname(userForm.getLastname())
                                    .image(resultFileName)
                                    .state(State.ACTIVE)
                                    .role(Role.USER)
                .build();
        userRepository.save(user);
    }
}
