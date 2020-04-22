package ru.knitu.form;

import lombok.Data;

@Data
public class ConferenceParticipantsForm {
    private String conference_id;
    private String workers_id;
    private String students_id;
}
