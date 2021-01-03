package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Conference;

import java.util.List;

public interface ConferenceRepository  extends JpaRepository<Conference, Long> {
    public Conference findOneByNameAndDateOfStartShow(String name, String dateOfStartShow);
    Conference findById(Long id);

    List<Conference> findAllByNameOrderByDateOfStart(String name);
}
