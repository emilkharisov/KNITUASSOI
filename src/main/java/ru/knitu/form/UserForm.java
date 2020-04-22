package ru.knitu.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class UserForm {
    @NotBlank(message = "Поле обязательно!")
    private String firstname;
    @NotBlank(message = "Поле обязательно!")
    private String lastname;
    @NotBlank(message = "Поле обязательно!")
    private String login;
    @NotBlank(message = "Поле обязательно!")
    private String password;
    @NotBlank(message = "Поле обязательно!")
    private String activateKey;
}
