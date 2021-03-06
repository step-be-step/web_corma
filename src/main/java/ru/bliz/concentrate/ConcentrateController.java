package ru.bliz.concentrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.grain_mix.Grain;
import ru.bliz.other.OtherKorm;

import java.util.List;

@Controller
public class ConcentrateController {

    @Autowired
    private ConcentrateRepo repo;

    @GetMapping("/concentrates")
    public String listCategories(Model model, String filter) {
        Iterable<Concentrate> listConcentrates;

        if (filter != null && !filter.isEmpty()) {
            listConcentrates = repo.findByName(filter);
        } else {
            listConcentrates = repo.findAll();
        }

        model.addAttribute("filter", filter);
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

    @GetMapping("/concentrates/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
        Concentrate concentrate = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("concentrate", concentrate);

        return "concentrate_form";
    }

    @GetMapping("/concentrates/delete/{id}")
    public String showDeleteCategoryForm(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);

        return "redirect:/concentrates";
    }
}
