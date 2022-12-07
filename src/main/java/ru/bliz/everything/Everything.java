package ru.bliz.everything;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bliz.buyer.Buyer;
import ru.bliz.insurance.Insurance;
import ru.bliz.user.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Everything {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String deadline;

    private String data;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

}
