package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.EducationalWorkForm;
import ru.knitu.model.EducationalWork;
import ru.knitu.model.Student;
import ru.knitu.model.Worker;
import ru.knitu.repo.EducationalWorkRepisitory;
import ru.knitu.repo.StudentRepository;
import ru.knitu.repo.WorkerRepository;

import java.util.Optional;

@Service
public class AddEducationalWorkServiceImpl implements AddWorkService {
    @Autowired
    EducationalWorkRepisitory educationalWorkRepisitory;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addWork(Object form) {
        EducationalWorkForm educationalWorkForm = (EducationalWorkForm) form;
        Student student = null;
        Worker worker = null;

        Long studentLong = null;
        Long workerLong = null;
        if(!educationalWorkForm.getStudent().equals("")){
            studentLong = Long.parseLong(educationalWorkForm.getStudent());
        }
        if(!educationalWorkForm.getWorker().equals("")){
            workerLong = Long.parseLong(educationalWorkForm.getWorker());
        }

        if (studentLong != null){
            student = studentRepository.findById(studentLong);
        }
        if (workerLong != null){
            worker = workerRepository.findById(workerLong);
        }
        EducationalWork educationalWork = EducationalWork.builder()
                        .typeOfWork(educationalWorkForm.getTypeOfWork())
                        .nameOfWork(educationalWorkForm.getNameOfWork())
                        .worker(worker)
                        .student(student)
                        .amountOfPages(educationalWorkForm.getAmountOfPages())
                        .yearOfPublication(educationalWorkForm.getYearOfPublication())
                        .publishing(educationalWorkForm.getPublishing())
                .build();
        educationalWorkRepisitory.save(educationalWork);
    }
}
