package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Data
public class WorkerForm {
    @NotBlank(message = "Поле обязательно")
    private String firstname;
    @NotBlank(message = "Поле обязательно")
    private String lastname;
    @NotBlank(message = "Поле обязательно")
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

    @NotBlank(message = "Поле обязательно")
    private String addressRegistration;
    @NotBlank(message = "Поле обязательно")
    private String addressPlaceOfResidence;
    @Email(message = "Неккоректная почта")
    @NotBlank(message = "Поле обязательно")
    private String email;
    private String rate;
    private String hiringConditionOfWorker;
    private String hiringTerm;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfPedBeginWork;
    @NotBlank(message = "Поле обязательно")
    private String thirdname;

    //Pasport
    @Pattern(regexp = "\\d{4}",message = "Неккоректный ввод серии паспорта")
    private String pasport;
    @Pattern(regexp = "\\d{6}",message = "Неккоректный ввод номера паспорта")
    private String pasport1;
    private String pasport2;
    @Pattern(regexp = "\\d{3}-\\d{3}",message = "Неккоректный ввод кода подразделения")
    private String pasport3;

    //Education
    private Boolean checkHigh;
    private Boolean checkAverage;
    private Boolean checkBegin;

    //High Education
    private String highDirection;
    private String highSpec;
    private String highNumber;
    private String highSeria;
    private String highYear;
    private String highOrganiation;
    //Avg Education
    private String avDirection;
    private String avSpec;
    private String avNumber;
    private String avSeria;
    private String avYear;
    private String avOrganiation;
    //Begin Education
    private String begDirection;
    private String begSpec;
    private String begNumber;
    private String begSeria;
    private String begYear;
    private String begOrganiation;
}
