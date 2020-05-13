package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IncreaseQualificationRelate;
import ru.knitu.model.Worker;

import java.util.List;

public interface IncreaseQualificationRelateRepository extends JpaRepository<IncreaseQualificationRelate, Long> {
    List<IncreaseQualificationRelate> findAllByWorker (Worker worker);
}
