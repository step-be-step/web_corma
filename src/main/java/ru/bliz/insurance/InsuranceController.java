package ru.bliz.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsuranceController {

    @Autowired
    private InsuranceRepo repo;

    @GetMapping("/insurances")
    public String listCategories(Model model, String filter) {
        Iterable<Insurance> listInsurances;

        if (filter != null && !filter.isEmpty()) {
            listInsurances = repo.findByName(filter);
        } else {
            listInsurances = repo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listInsurances", listInsurances);

        return "insurances";
    }

    @GetMapping("/insurances/new")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("insurance", new Insurance());

        return "insurance_form";
    }

    @PostMapping("/insurances/save")
    public String saveCategory(Insurance Insurance) {
        repo.save(Insurance);

        return "redirect:/insurances";
    }

    @GetMapping("/insurances/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
        Insurance Insurance = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("insurance", Insurance);

        return "insurance_form";
    }

    @GetMapping("/insurances/delete/{id}")
    public String showDeleteCategoryForm(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);

        return "redirect:/insurances";
    }
}
