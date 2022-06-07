package ru.bliz.sales;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bliz.combocorm.Combicorm;
import ru.bliz.concentrate.Concentrate;
import ru.bliz.foodForCatAndDog.FoodForCatAndDog;
import ru.bliz.grain_mix.Grain;
import ru.bliz.other.OtherKorm;

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

    @ManyToOne
    @JoinColumn(name = "other_korm_id")
    private OtherKorm otherKorm;

    @ManyToOne
    @JoinColumn(name = "combicorm_id")
    private Combicorm combicorm;

    @ManyToOne
    @JoinColumn(name = "grain_id")
    private Grain grain;

    @ManyToOne
    @JoinColumn(name = "food_for_cat_and_dog_id")
    private FoodForCatAndDog food;
}
