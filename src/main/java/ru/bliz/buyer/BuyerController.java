package ru.bliz.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyerController {

    @Autowired
    private BuyerRepo repo;

    @GetMapping("/buyers")
    public String listCategories(Model model, String filter) {
        Iterable<Buyer> listBuyers;

        if (filter != null && !filter.isEmpty()) {
            listBuyers = repo.findByName(filter);
        } else {
            listBuyers = repo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listBuyers", listBuyers);

        return "buyers";
    }

    @GetMapping("/buyers/new")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("buyer", new Buyer());

        return "buyer_form";
    }

    @PostMapping("/buyers/save")
    public String saveCategory(Buyer Buyer) {
        repo.save(Buyer);

        return "redirect:/buyers";
    }

    @GetMapping("/buyers/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
        Buyer Buyer = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("buyer", Buyer);

        return "buyer_form";
    }

    @GetMapping("/buyers/delete/{id}")
    public String showDeleteCategoryForm(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);

        return "redirect:/buyers";
    }
}
