package ru.bliz.insurance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
    Iterable<Insurance> findByName(String filter);
}
