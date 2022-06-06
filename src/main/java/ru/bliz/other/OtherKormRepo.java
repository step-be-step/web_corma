package ru.bliz.other;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherKormRepo extends JpaRepository<OtherKorm, Integer> {
    Iterable<OtherKorm> findByName(String filter);
}
