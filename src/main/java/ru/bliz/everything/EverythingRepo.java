package ru.bliz.everything;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EverythingRepo extends JpaRepository<Everything, Integer> {
    Iterable<Everything> findByName(String filter);
}
