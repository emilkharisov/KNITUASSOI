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
        if (educationalWorkForm.getStudent() != null){
            student = studentRepository.findById(educationalWorkForm.getStudent());
        }
        if (educationalWorkForm.getWorker() != null){
            worker = workerRepository.findById(educationalWorkForm.getWorker());
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
