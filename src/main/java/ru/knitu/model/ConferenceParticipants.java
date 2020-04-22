package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "conference_participants")
@Builder
public class ConferenceParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long conference_id;
    private Long worker_id;
    private Long student_id;
}
