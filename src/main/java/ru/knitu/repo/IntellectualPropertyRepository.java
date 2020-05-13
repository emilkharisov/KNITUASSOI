package ru.knitu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.knitu.model.IntellectualProperty;
import ru.knitu.model.Worker;

public interface IntellectualPropertyRepository extends JpaRepository<IntellectualProperty, Long> {
    IntellectualProperty findByNameAndOwner(String name, String owner);
}
