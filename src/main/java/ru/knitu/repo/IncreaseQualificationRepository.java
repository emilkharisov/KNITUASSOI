package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IncreaseQualification;

import java.util.List;

public interface IncreaseQualificationRepository extends JpaRepository<IncreaseQualification, Long> {
    IncreaseQualification findByProgrammAndDateOfEndShow(String programm, String dateOfEndShow);
    IncreaseQualification findById(long id);

    List<IncreaseQualification>  findAllByProgramm(String name);
}
