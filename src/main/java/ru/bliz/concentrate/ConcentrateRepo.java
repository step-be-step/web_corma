package ru.bliz.concentrate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcentrateRepo extends JpaRepository<Concentrate, Integer> {
    Iterable<Concentrate> findByName(String filter);
}
