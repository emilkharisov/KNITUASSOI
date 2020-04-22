package ru.knitu.service;

import ru.knitu.form.ConferenceForm;

import java.text.ParseException;

public interface AddConferenceService {
    public void addConference(ConferenceForm conferenceForm) throws ParseException;
}
