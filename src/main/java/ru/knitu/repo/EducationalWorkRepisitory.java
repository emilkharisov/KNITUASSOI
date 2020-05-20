package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.knitu.model.EducationalWork;
import ru.knitu.model.ScienceWork;
import ru.knitu.model.Worker;


import java.util.List;

public interface EducationalWorkRepisitory  extends JpaRepository<EducationalWork, Long> {
    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Учебники' AND yearOfPublication=:yearOfPublication")
    List<EducationalWork> getListByYearOfPublicationBooks(@Param("yearOfPublication") int yearOfPublication);

    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Учебники'")
    List<EducationalWork> getPatentsListBooks();

    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Методические указания' AND yearOfPublication=:yearOfPublication")
    List<EducationalWork> getListByYearOfPublicationMethodology(@Param("yearOfPublication") int yearOfPublication);

    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Методические указания'")
    List<EducationalWork> getPatentsListMethodology();

    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Учебные пособия' AND yearOfPublication=:yearOfPublication")
    List<EducationalWork> getListByYearOfPublicationBenefits(@Param("yearOfPublication") int yearOfPublication);

    @Query("SELECT e FROM EducationalWork e WHERE typeOfWork='Учебные пособия'")
    List<EducationalWork> getPatentsListBenefits();

    List<EducationalWork> findAllByWorker(Worker worker);

    List<EducationalWork> findAllByStudentIsNotNull();

    List<EducationalWork> findAllByStudentIsNotNullAndYearOfPublication(int yearOfPublication);

    @Query("SELECT e FROM EducationalWork e ORDER BY typeOfWork")
    List<EducationalWork> findAllSorted();

    List<EducationalWork> findAllByYearOfPublicationOrderByTypeOfWork(int year);

}
