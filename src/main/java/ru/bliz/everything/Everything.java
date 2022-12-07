package ru.bliz.everything;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bliz.concentrate.Concentrate;
import ru.bliz.insurance.Insurance;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Everything {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

}
