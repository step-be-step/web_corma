package ru.bliz.concentrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ConcentrateController {

    @Autowired
    private ConcentrateRepo repo;

    @GetMapping("/concentrates")
    public String listCategories(Model model) {
        List<Concentrate> listConcentrates = repo.findAll();
        model.addAttribute("listConcentrates", listConcentrates);

        return "concentrates";
    }

    @GetMapping("/concentrates/new")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("concentrate", new Concentrate());

        return "concentrate_form";
    }

    @PostMapping("/concentrates/save")
    public String saveCategory(Concentrate concentrate) {
        repo.save(concentrate);

        return "redirect:/concentrates";
    }
}
