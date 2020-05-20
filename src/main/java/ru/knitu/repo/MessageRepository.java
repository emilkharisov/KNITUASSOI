package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.knitu.model.Message;
import ru.knitu.model.ScienceWork;
import ru.knitu.model.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {


    List<Message> findAllByFromUserAndToUserOrFromUserAndToUserOrderByDate(User from, User to, User from2, User to2);

}
