package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IntellectualPropertyAuthors;
import ru.knitu.model.ScienceWork;
import ru.knitu.model.Worker;

import java.util.List;

public interface IntellectualPropertyAuthorsRepository extends JpaRepository<IntellectualPropertyAuthors, Long> {
    List<IntellectualPropertyAuthors> findAllByWorker(Worker worker);
}
