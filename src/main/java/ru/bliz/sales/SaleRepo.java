package ru.bliz.sales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<Sale, Integer> {
}
