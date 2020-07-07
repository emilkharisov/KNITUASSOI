package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.ScienceWorkForm;
import ru.knitu.model.ScienceWork;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;
import ru.knitu.repo.ScienceWorkRepository;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;


@Service
public class AddScienceWorkServiceImpl implements AddWorkService {
    @Autowired
    ScienceWorkRepository scienceWorkRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addWork(Object form) {
        ScienceWorkForm scienceWorkForm = (ScienceWorkForm) form;


        ScienceWork scienceWork = ScienceWork.builder()
                .typeOfWork(scienceWorkForm.getTypeOfWork())
                .nameOfWork(scienceWorkForm.getNameOfWork())
                .nameOfJournal(scienceWorkForm.getNameOfJournal())
                .numberOfJournal(scienceWorkForm.getNumberOfJournal())
                .pages(scienceWorkForm.getPages())
                .rinc(scienceWorkForm.isRinc())
                .scopus(scienceWorkForm.isScopus())
                .yearOfPublication(scienceWorkForm.getYearOfPublication())
                .tom(scienceWorkForm.getTom())
                .build();
        scienceWorkRepository.save(scienceWork);
    }
}
