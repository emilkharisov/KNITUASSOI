package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Conference;

public interface ConferenceRepository  extends JpaRepository<Conference, Long> {
    public Conference findOneByNameAndDateOfStartShow(String name, String dateOfStartShow);
    Conference findById(Long id);
}
