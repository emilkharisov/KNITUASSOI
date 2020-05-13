package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.IntellectualPropertyForm;
import ru.knitu.model.IntellectualProperty;
import ru.knitu.repo.IntellectualPropertyRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class IntellectualPropertyService {

    @Autowired
    IntellectualPropertyRepository intellectualPropertyRepository;

    public void addIntellectualProperty(IntellectualPropertyForm intellectualPropertyForm) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatForShow = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOfAssignment = simpleDateFormat.parse(intellectualPropertyForm.getDateOfAssignment());
        Date dateOfExpiration = simpleDateFormat.parse(intellectualPropertyForm.getDateOfExpiration());
        Date dateOfPriority = simpleDateFormat.parse(intellectualPropertyForm.getDateOfPriority());
        Date dateOfPublication = simpleDateFormat.parse(intellectualPropertyForm.getDateOfPublication());

        IntellectualProperty intellectualProperty = IntellectualProperty.builder()
                .name(intellectualPropertyForm.getName())
                .numberOfDocument(intellectualPropertyForm.getNumberOfDocument())
                .numberOfRequest(intellectualPropertyForm.getNumberOfRequest())
                .object(intellectualPropertyForm.getObject())
                .owner(intellectualPropertyForm.getOwner())
                .registrationNumber(intellectualPropertyForm.getRegistrationNumber())
                .typeOfDocument(intellectualPropertyForm.getTypeOfDocument())
                .dateOfAssignment(dateOfAssignment)
                .dateOfExpiration(dateOfExpiration)
                .dateOfPriority(dateOfPriority)
                .dateOfPublication(dateOfPublication)
                .dateOfAssignmentShow(simpleDateFormatForShow.format(dateOfAssignment))
                .dateOfExpirationShow(simpleDateFormatForShow.format(dateOfExpiration))
                .dateOfPriorityShow(simpleDateFormatForShow.format(dateOfPriority))
                .dateOfPublicationShow(simpleDateFormatForShow.format(dateOfPublication))
        .build();

        intellectualPropertyRepository.save(intellectualProperty);

    }
}
