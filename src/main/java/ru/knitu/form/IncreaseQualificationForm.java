package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class IncreaseQualificationForm {
    @NotBlank(message = "Поле обязательно")
    private String programm;
    private int countOfHours;
    @NotBlank(message = "Поле обязательно")
    private String organisation;
    private int seria;
    private int number;
    @NotBlank(message = "Поле обязательно")
    private String nameOfDocument;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfBegin;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfEnd;


}
