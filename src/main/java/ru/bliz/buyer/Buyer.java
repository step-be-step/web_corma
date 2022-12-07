package ru.bliz.buyer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    public Buyer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Buyer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}