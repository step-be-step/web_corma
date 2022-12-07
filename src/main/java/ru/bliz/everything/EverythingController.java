package ru.bliz.everything;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.insurance.Insurance;
import ru.bliz.insurance.InsuranceRepo;

import java.util.List;

@Controller
public class EverythingController {

    @Autowired
    private EverythingRepo everythingRepo;

    @Autowired
    private InsuranceRepo insuranceRepo;

    @GetMapping("/everythings/new")
    public String showNewSaleFrom(Model model) {
        List<Insurance> listInsurances = insuranceRepo.findAll();

        model.addAttribute("everything", new Everything());

        model.addAttribute("listInsurances", listInsurances);

        return "everythings_form";
    }

    @PostMapping("/everythings/save")
    public String saveSale(Everything everything) {
        everythingRepo.save(everything);

        return "redirect:/everythings";
    }

    @GetMapping("/everythings")
    public String listSales(Model model, String filter) {

        Iterable<Everything> listSales;

        if (filter != null && !filter.isEmpty()) {
            listSales = everythingRepo.findByName(filter);
        } else {
            listSales = everythingRepo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listSales", listSales);

        return "everythings";
    }

    @GetMapping("/everythings/edit/{id}")
    public String showEditSaleForm(@PathVariable("id") Integer id, Model model) {
        Everything everything = everythingRepo.findById(id).get();

        List<Insurance> listInsurances = insuranceRepo.findAll();

        model.addAttribute("everything", everything);

        model.addAttribute("listInsurances", listInsurances);

        return "everythings_form";
    }

    @GetMapping("/everythings/delete/{id}")
    public String showDeleteSaleForm(@PathVariable("id") Integer id, Model model) {
        everythingRepo.deleteById(id);

        return "redirect:/everythings";
    }
}
