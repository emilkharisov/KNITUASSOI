package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Message;
import ru.knitu.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
    List<User> findAllByLastnameContaining(String lastname);
}
