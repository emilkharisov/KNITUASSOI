package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ConferenceForm {

    @NotBlank(message = "Поле обязательно")
    private String name;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfStart;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfEnd;
    @NotBlank(message = "Поле обязательно")
    private String city;
    private String level;

}
