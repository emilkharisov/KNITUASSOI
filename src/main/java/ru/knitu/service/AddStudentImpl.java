package ru.knitu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.StudentForm;
import ru.knitu.model.Student;
import ru.knitu.repo.StudentRepository;

@Service
public class AddStudentImpl implements AddStudent {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(StudentForm studentForm) {

        Student student = Student.builder()
                .firstname(studentForm.getFirstname())
                .lastname(studentForm.getLastname())
                .thirdname(studentForm.getThirdname())
                .telephone(studentForm.getTelephone())
                .educationLevel(studentForm.getEducationLevel())
                .formOfEducation(studentForm.getFormOfEducation())
                .direction(studentForm.getDirection())
                .educationGroup(studentForm.getGroup())
        .build();

        studentRepository.save(student);
    }
}
