package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.CandidateWorkForm;
import ru.knitu.model.CandidateWork;
import ru.knitu.repo.CandidateWorkRepository;
import ru.knitu.repo.WorkerRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CandidateWorkService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    CandidateWorkRepository candidateWorkRepository;

    public void addCandidateWork(CandidateWorkForm candidateWorkForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");
        Date date = simpleDateFormat.parse(candidateWorkForm.getDate());

        CandidateWork candidateWork = CandidateWork.builder()
                .type(candidateWorkForm.getType())
                .date(date)
                .name(candidateWorkForm.getName())
                .dateShow(simpleDateFormatForShow.format(date))
                .numberOfDocument(candidateWorkForm.getNumberOfDocument())
                .specialization(candidateWorkForm.getSpecialization())
                .place(candidateWorkForm.getPlace())
                .worker(workerRepository.findById(candidateWorkForm.getWorker()))
                .sciences(candidateWorkForm.getSciences())
        .build();

        candidateWorkRepository.save(candidateWork);

    }

}
