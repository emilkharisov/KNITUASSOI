package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IncreaseQualification;

public interface IncreaseQualificationRepository extends JpaRepository<IncreaseQualification, Long> {
    IncreaseQualification findByProgrammAndDateOfEndShow(String programm, String dateOfEndShow);
    IncreaseQualification findById(long id);
}
