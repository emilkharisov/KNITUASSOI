package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class IntellectualPropertyForm {
    @NotBlank(message = "Поле обязательно")
    private String registrationNumber;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfPublication;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfAssignment;
    @NotBlank(message = "Поле обязательно")
    private String owner;
    private String object;
    @NotBlank(message = "Поле обязательно")
    private String name;
    private String typeOfDocument;
    private int numberOfDocument;
    private int numberOfRequest;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfPriority;
    @Size(max = 10, min = 10, message = "Неккоректный ввод даты")
    private String dateOfExpiration;
}
