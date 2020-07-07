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
@Table(name = "educationWork")
@Builder
public class EducationalWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOfWork;
    private String nameOfWork;
    private int amountOfPages;
    private int yearOfPublication;
    private String publishing;
}
