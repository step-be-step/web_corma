package ru.bliz.combocorm;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Combicorm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private float priceKg;
    private float price25Kg;

    public Combicorm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Combicorm(String name, float priceKg, float price25Kg) {
        this.name = name;
        this.priceKg = priceKg;
        this.price25Kg = price25Kg;
    }
}