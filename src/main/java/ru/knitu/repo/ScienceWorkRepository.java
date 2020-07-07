package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.knitu.model.EducationalWork;
import ru.knitu.model.ScienceWork;
import ru.knitu.model.Worker;


import java.util.List;

public interface ScienceWorkRepository extends JpaRepository<ScienceWork, Long> {
   //
    @Query("SELECT s FROM ScienceWork s WHERE typeOfWork='Патенты' AND yearOfPublication=:yearOfPublication")
    List<ScienceWork> getListByYearOfPublication(@Param("yearOfPublication") int yearOfPublication);

    @Query("SELECT s FROM ScienceWork s WHERE typeOfWork='Патенты'")
    List<ScienceWork> getPatentsList();

    @Query("SELECT s FROM ScienceWork s ORDER BY typeOfWork")
    List<ScienceWork> findAllSorted();

    List<ScienceWork> findAllByYearOfPublicationOrderByTypeOfWork(int year);

    ScienceWork findById(long id);

}
