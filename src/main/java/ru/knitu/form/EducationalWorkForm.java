package ru.knitu.form;

import lombok.Data;

@Data
public class EducationalWorkForm {
    private String typeOfWork;
    private String nameOfWork;
    private String worker;
    private String student;
    private int amountOfPages;
    private int yearOfPublication;
    private String publishing;
}

