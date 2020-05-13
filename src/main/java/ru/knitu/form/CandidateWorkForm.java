package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class CandidateWorkForm {
    @NotBlank(message = "Поле обязательно")
    private String name;
    private long worker;
    @NotBlank(message = "Поле обязательно")
    private String numberOfDocument;
    @NotBlank(message = "Поле обязательно")
    private String sciences;
    private String specialization;
    @NotBlank(message = "Поле обязательно")
    private String place;
    private String type;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String date;

}
