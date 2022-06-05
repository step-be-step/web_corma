package ru.bliz.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.concentrate.Concentrate;
import ru.bliz.concentrate.ConcentrateRepo;

import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private ConcentrateRepo concentrateRepo;

    @GetMapping("/sales/new")
    public String showNewProductFrom(Model model) {
        List<Concentrate> listConcentrates = concentrateRepo.findAll();

        model.addAttribute("sale", new Sale());
        model.addAttribute("listConcentrates", listConcentrates);

        return "sales_form";
    }

    @PostMapping("/sales/save")
    public String saveProduct(Sale sale) {
        saleRepo.save(sale);

        return "redirect:/sales";
    }

    @GetMapping("/sales")
    public String listProducts(Model model) {
        List<Sale> listSales = saleRepo.findAll();
        model.addAttribute("listSales", listSales);

        return "sales";
    }

    @GetMapping("/sales/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Sale sale = saleRepo.findById(id).get();
        model.addAttribute("sale", sale);

        List<Concentrate> listConcentrates = concentrateRepo.findAll();

        model.addAttribute("listConcentrates", listConcentrates);

        return "sales_form";
    }

    @GetMapping("/sales/delete/{id}")
    public String showDeleteProductForm(@PathVariable("id") Integer id, Model model) {
        saleRepo.deleteById(id);

        return "redirect:/sales";
    }
}
