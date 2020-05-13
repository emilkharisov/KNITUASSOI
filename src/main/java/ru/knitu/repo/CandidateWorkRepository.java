package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.CandidateWork;
import ru.knitu.model.Worker;

import java.util.List;

public interface CandidateWorkRepository extends JpaRepository<CandidateWork, Long> {
    List <CandidateWork> findAllByWorker(Worker worker);
}
