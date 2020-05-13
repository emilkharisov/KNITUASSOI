package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "intellectual_property")
@Builder
public class IntellectualProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String registrationNumber;
    private String dateOfPublicationShow;
    private String dateOfAssignmentShow;
    private String owner;
    private String object;
    private String name;
    private String typeOfDocument;
    private int numberOfDocument;
    private int numberOfRequest;
    private String dateOfPriorityShow;
    private String dateOfExpirationShow;
    private Date dateOfAssignment;
    private Date dateOfExpiration;
    private Date dateOfPriority;
    private Date dateOfPublication;
}
