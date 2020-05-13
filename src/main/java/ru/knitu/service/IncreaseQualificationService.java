package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.IncreaseQualificationForm;
import ru.knitu.model.IncreaseQualification;
import ru.knitu.repo.IncreaseQualificationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class IncreaseQualificationService {

    @Autowired
    IncreaseQualificationRepository increaseQualificationRepository;

    public void addIncreaseQualification(IncreaseQualificationForm increaseQualificationForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOfBegin = simpleDateFormat.parse(increaseQualificationForm.getDateOfBegin());
        Date dateOfEnd = simpleDateFormat.parse(increaseQualificationForm.getDateOfEnd());

        IncreaseQualification increaseQualification = IncreaseQualification.builder()
                .programm(increaseQualificationForm.getProgramm())
                .countOfHours(increaseQualificationForm.getCountOfHours())
                .dateOfBegin(dateOfBegin)
                .dateOfEnd(dateOfEnd)
                .dateOfBeginShow(simpleDateFormatForShow.format(dateOfBegin))
                .dateOfEndShow(simpleDateFormatForShow.format(dateOfEnd))
                .nameOfDocument(increaseQualificationForm.getNameOfDocument())
                .seria(increaseQualificationForm.getSeria())
                .number(increaseQualificationForm.getNumber())
                .organisation(increaseQualificationForm.getOrganisation())
        .build();

        increaseQualificationRepository.save(increaseQualification);

    }
}
