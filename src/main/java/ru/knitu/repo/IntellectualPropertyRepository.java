package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IntellectualProperty;
import ru.knitu.model.Worker;

import java.util.List;

public interface IntellectualPropertyRepository extends JpaRepository<IntellectualProperty, Long> {
    IntellectualProperty findByNameAndOwner(String name, String owner);
    IntellectualProperty findById(Long id);
    List<IntellectualProperty> findAllByName(String name);

}
