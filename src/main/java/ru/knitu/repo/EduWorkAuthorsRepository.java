package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.EducationalWork;
import ru.knitu.model.EducationalWorkAuthors;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;

import java.util.List;

public interface EduWorkAuthorsRepository extends JpaRepository<EducationalWorkAuthors, Long> {
    List<EducationalWorkAuthors> findAllByWorker(Worker worker);
    List<EducationalWorkAuthors> findAllByStudentIsNotNull();

    List<EducationalWorkAuthors> findAllByStudent(Student student);

    List<EducationalWorkAuthors> findAllByEducationalWork(EducationalWork educationalWork);

}
