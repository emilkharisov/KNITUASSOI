package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "workers_assoi")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String thirdname;
    private String telephone;
    private String education;
    private String position;
    private String academicRank;
    private String academicDegree;
    private Date dateOfBeginWork;
    private Date dateEndOfContract;
    private Date dateOfBirth;
    private Boolean checkMagistr;
    private String image;
    private String dateOfBeginWorkShow;
    private String dateEndOfContractShow;
    private String dateOfBirthShow;
    // Additions for requerements
    private String addressRegistration;
    private String addressPlaceOfResidence;
    private String email;
    private String pasport;
    private String rate;
    private String hiringConditionOfWorker;
    private String hiringTerm;
    private Date dateOfPedBeginWork;
    private String dateOfPedBeginWorkShow;
    private Boolean highEducation;
    private Boolean avgEducation;
    private Boolean begEducation;
    private String highEducationInfo;
    private String avgEducationInfo;
    private String begEducationInfo;

    private Date qualificationDate;

}
