package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "science_work")
@Builder
public class ScienceWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
