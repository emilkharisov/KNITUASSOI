package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
public class WorkerForm {
    @NotBlank(message = "Поле обяхательно")
    private String firstname;
    @NotBlank(message = "Поле обяхательно")
    private String lastname;
    @NotBlank(message = "Поле обяхательно")
    @Pattern(regexp = "[8]{1}\\d{10}",message = "Неккоректный ввод номера телефона")
    private String telephone;
    private String education;
    private String position;
    private String academicRank;
    private String academicDegree;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfBeginWork;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateEndOfContract;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfBirth;
    private Boolean checkMagistr;
    private int excperience;

    private String addressRegistration;
    private String addressPlaceOfResidence;
    private String email;
    private String rate;
    private String hiringConditionOfWorker;
    private String hiringTerm;
    private String dateOfPedBeginWork;
    private String thirdname;

    //Pasport
    private String pasport;
    private String pasport1;
    private String pasport2;
    private String pasport3;
}
