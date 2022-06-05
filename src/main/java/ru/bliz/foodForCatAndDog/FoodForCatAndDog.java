package ru.bliz.foodForCatAndDog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class FoodForCatAndDog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private float priceKg;
    private float price25Kg;

    public FoodForCatAndDog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FoodForCatAndDog(String name, float priceKg, float price25Kg) {
        this.name = name;
        this.priceKg = priceKg;
        this.price25Kg = price25Kg;
    }
}