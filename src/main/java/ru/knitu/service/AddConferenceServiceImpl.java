package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.ConferenceForm;
import ru.knitu.model.Conference;
import ru.knitu.repo.ConferenceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AddConferenceServiceImpl implements AddConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

    @Override
    public void addConference(ConferenceForm conferenceForm) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfStart = simpleDateFormat.parse(conferenceForm.getDateOfStart());
        Date dateOfEnd = simpleDateFormat.parse(conferenceForm.getDateOfEnd());

        Conference conference = Conference.builder()
                .name(conferenceForm.getName())
                .dateOfStart(dateOfStart)
                .dateOfEnd(dateOfEnd)
                .city(conferenceForm.getCity())
                .level(conferenceForm.getLevel())
                .dateOfStartShow(simpleDateFormatForShow.format(dateOfStart))
                .dateOfEndShow(simpleDateFormatForShow.format(dateOfEnd))
        .build();
        conferenceRepository.save(conference);

    }
}
