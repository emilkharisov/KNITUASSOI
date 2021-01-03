package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.*;

import java.util.List;

public interface ScWorkAuthorsRepository extends JpaRepository<ScienceWorkAuthors, Long> {
    List<ScienceWorkAuthors> findAllByWorker(Worker worker);
    List<ScienceWorkAuthors> findAllByStudentIsNotNull();

    List<ScienceWorkAuthors> findAllByStudent(Student student);

    List <ScienceWorkAuthors> findAllByScienceWork(ScienceWork scienceWork);
}
