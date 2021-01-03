package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.knitu.model.Conference;
import ru.knitu.model.ConferenceParticipants;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;

import java.util.List;

public interface ConferenceParticipantsRepository  extends JpaRepository<ConferenceParticipants, Long> {
    List<ConferenceParticipants> findAllByWorker(Worker worker);

    ConferenceParticipants findByStudent(Student student);

    List<ConferenceParticipants> findAllByStudent(Student student);

    @Query("SELECT e FROM ConferenceParticipants e WHERE conference_id=:conference_id")
    List<ConferenceParticipants> getConferenceParticipants(@Param("conference_id") Long conference_id);


}
