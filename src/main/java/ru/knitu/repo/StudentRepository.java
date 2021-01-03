package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;

import java.util.List;


public interface StudentRepository  extends JpaRepository<Student, Long> {
    Student findByLastnameAndFirstnameAndThirdnameAndEducationGroup(String lastname, String firstname, String thirdname, String group);
    Student findByLastnameAndFirstnameAndThirdname(String lastname, String firstname, String thirdname);
    Student findById(Long id);

    List<Student> findAllByLastname(String lastname);
}
