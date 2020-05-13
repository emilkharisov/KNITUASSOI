package ru.knitu.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "increaseQualification")
@Builder
public class IncreaseQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String programm;
    private int countOfHours;
    private String organisation;
    private int seria;
    private int number;
    private String nameOfDocument;
    private Date dateOfBegin;
    private Date dateOfEnd;
    private String dateOfBeginShow;
    private String dateOfEndShow;

}
