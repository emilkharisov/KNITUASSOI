package ru.knitu.form;

import lombok.Data;

import java.util.Date;

@Data
public class ConferenceForm {

    private String name;
    private String dateOfStart;
    private String dateOfEnd;
    private String city;
    private String level;

}
