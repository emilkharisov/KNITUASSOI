package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.Conference;
import ru.knitu.model.ConferenceParticipants;
import ru.knitu.model.Worker;

import java.util.List;

public interface ConferenceParticipantsRepository  extends JpaRepository<ConferenceParticipants, Long> {
    List<ConferenceParticipants> findAllByWorker(Worker worker);
}
