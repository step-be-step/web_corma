package ru.bliz.foodForCatAndDog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.other.OtherKorm;

import java.util.List;

@Controller
public class FoodForCatAndDogController {

    @Autowired
    private FoodForCatAndDogRepo repo;

    @GetMapping("/food_for_cat_and_dog")
    public String listFoodForCatAndDog(Model model, String filter) {
        Iterable<FoodForCatAndDog> listFoods;

        if (filter != null && !filter.isEmpty()) {
            listFoods = repo.findByName(filter);
        } else {
            listFoods = repo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listFoods", listFoods);

        return "foods";
    }

    @GetMapping("/food_for_cat_and_dog/new")
    public String showFoodForCatAndDogNewForm(Model model) {
        model.addAttribute("food", new FoodForCatAndDog());

        return "food_form";
    }

    @PostMapping("/food_for_cat_and_dog/save")
    public String saveFoodForCatAndDog(FoodForCatAndDog concentrate) {
        repo.save(concentrate);

        return "redirect:/food_for_cat_and_dog";
    }

    @GetMapping("/food_for_cat_and_dog/edit/{id}")
    public String showEditFoodForCatAndDogForm(@PathVariable("id") Integer id, Model model) {
        FoodForCatAndDog combicorm = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("food", combicorm);

        return "food_form";
    }

    @GetMapping("/food_for_cat_and_dog/delete/{id}")
    public String showDeleteFoodForCatAndDogForm(@PathVariable("id") Integer id) {
        repo.deleteById(id);

        return "redirect:/food_for_cat_and_dog";
    }
}
