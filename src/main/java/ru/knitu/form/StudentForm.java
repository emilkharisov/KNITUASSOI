package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
public class StudentForm {
    @NotBlank(message = "Поле обязательно")
    private String firstname;
    @NotBlank(message = "Поле обязательно")
    private String lastname;
    @NotBlank(message = "Поле обязательно")
    private String thirdname;
    @Pattern(regexp = "[8]{1}\\d{10}",message = "Неккоректный ввод номера телефона")
    private String telephone;
    private String educationLevel;
    private  String formOfEducation;
    @NotBlank(message = "Поле обязательно")
    @Pattern(regexp = "\\d{2}\\.\\d{2}\\.\\d{2}",message = "Неккоректный ввод направления")
    private String direction;
    @NotBlank(message = "Поле обязательно")
    private String group;
}
