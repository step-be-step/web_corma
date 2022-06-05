package ru.bliz.combocorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CombicormController {

    @Autowired
    private CombicormRepo repo;

    @GetMapping("/combicorms")
    public String listCategories(Model model) {
        List<Combicorm> listCombicorms = repo.findAll();
        model.addAttribute("listCombicorms", listCombicorms);

        return "combicorms";
    }

    @GetMapping("/combicorms/new")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("combicorm", new Combicorm());

        return "combicorm_form";
    }

    @PostMapping("/combicorms/save")
    public String saveCategory(Combicorm concentrate) {
        repo.save(concentrate);

        return "redirect:/combicorms";
    }

    @GetMapping("/combicorms/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Combicorm combicorm = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("combicorm", combicorm);

        return "combicorm_form";
    }

    @GetMapping("/combicorms/delete/{id}")
    public String showDeleteProductForm(@PathVariable("id") Integer id) {
        repo.deleteById(id);

        return "redirect:/combicorms";
    }
}
