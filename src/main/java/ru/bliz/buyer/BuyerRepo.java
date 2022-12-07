package ru.bliz.buyer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<Buyer, Integer> {
    Iterable<Buyer> findByName(String filter);
}
