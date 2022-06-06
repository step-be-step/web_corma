package ru.bliz.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.sales.Sale;

import java.util.List;

@Controller
public class OtherKormController {

    @Autowired
    private OtherKormRepo repo;

    @GetMapping("/others")
    public String listCategories(Model model, String filter) {
        Iterable<OtherKorm> listOthers;

        if (filter != null && !filter.isEmpty()) {
            listOthers = repo.findByName(filter);
        } else {
            listOthers = repo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listOthers", listOthers);

        return "others";
    }

    @GetMapping("/others/new")
    public String showOtherNewForm(Model model) {
        model.addAttribute("other", new OtherKorm());

        return "other_form";
    }

    @PostMapping("/others/save")
    public String saveOther(OtherKorm concentrate) {
        repo.save(concentrate);

        return "redirect:/others";
    }

    @GetMapping("/others/edit/{id}")
    public String showEditOtherForm(@PathVariable("id") Integer id, Model model) {
        OtherKorm other = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("other", other);

        return "other_form";
    }

    @GetMapping("/others/delete/{id}")
    public String showDeleteOtherForm(@PathVariable("id") Integer id) {
        repo.deleteById(id);

        return "redirect:/others";
    }
}
