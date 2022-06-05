package ru.bliz.grain_mix;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrainRepo extends JpaRepository<Grain, Integer> {
}
