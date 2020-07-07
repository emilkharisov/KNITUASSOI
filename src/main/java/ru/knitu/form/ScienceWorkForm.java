package ru.knitu.form;

import lombok.Data;

@Data
public class ScienceWorkForm {
    private String typeOfWork;
    private String nameOfWork;
    private String nameOfJournal;
    private int tom;
    private int pages;
    private int numberOfJournal;
    private int yearOfPublication;
    private boolean rinc;
    private boolean scopus;
}
