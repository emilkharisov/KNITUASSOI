package ru.knitu.service;

import org.springframework.stereotype.Service;
import ru.knitu.form.StudentForm;


public interface AddStudent {
    public void  addStudent(StudentForm studentForm);
}
