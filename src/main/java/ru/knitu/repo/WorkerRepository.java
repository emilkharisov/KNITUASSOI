package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;

        import java.util.Date;
        import java.util.List;


public interface WorkerRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAllByAcademicDegree(String academicDegree);

    List<Worker> findAllByLastname(String lastname);

    List<Worker> findAllByCheckMagistrIsNull();

    Worker findById(Long id);

    List<Worker> findAllByLastnameContaining(String lastname);

    Worker findByLastnameAndFirstnameAndThirdnameAndPosition(String lastname, String firstname, String thirdname, String position);
    Worker findByLastnameAndFirstnameAndThirdname(String lastname, String firstname, String thirdname);

}
