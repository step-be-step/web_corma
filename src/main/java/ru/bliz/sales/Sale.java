package ru.bliz.sales;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bliz.concentrate.Concentrate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "concentrate_id")
    private Concentrate concentrate;
}
