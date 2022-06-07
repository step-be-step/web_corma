package ru.bliz.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.combocorm.Combicorm;
import ru.bliz.combocorm.CombicormRepo;
import ru.bliz.concentrate.Concentrate;
import ru.bliz.concentrate.ConcentrateRepo;
import ru.bliz.foodForCatAndDog.FoodForCatAndDog;
import ru.bliz.foodForCatAndDog.FoodForCatAndDogRepo;
import ru.bliz.grain_mix.Grain;
import ru.bliz.grain_mix.GrainRepo;
import ru.bliz.other.OtherKorm;
import ru.bliz.other.OtherKormRepo;

import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private ConcentrateRepo concentrateRepo;
    @Autowired
    private OtherKormRepo otherKormRepo;
    @Autowired
    private CombicormRepo combicormRepo;
    @Autowired
    private GrainRepo grainRepo;
    @Autowired
    private FoodForCatAndDogRepo foodRepo;

    @GetMapping("/sales/new")
    public String showNewSaleFrom(Model model) {
        List<Concentrate> listConcentrates = concentrateRepo.findAll();
        List<OtherKorm> listOther = otherKormRepo.findAll();
        List<Combicorm> listCombicorms = combicormRepo.findAll();
        List<FoodForCatAndDog> listFoods = foodRepo.findAll();
        List<Grain> listGrain = grainRepo.findAll();

        model.addAttribute("sale", new Sale());

        model.addAttribute("listOther", listOther);
        model.addAttribute("listConcentrates", listConcentrates);
        model.addAttribute("listCombicorms", listCombicorms);
        model.addAttribute("listFoods", listFoods);
        model.addAttribute("listGrain", listGrain);


        return "sales_form";
    }

    @PostMapping("/sales/save")
    public String saveSale(Sale sale) {
        saleRepo.save(sale);

        return "redirect:/sales";
    }

    @GetMapping("/sales")
    public String listSales(Model model, String filter) {

        Iterable<Sale> listSales;

        if (filter != null && !filter.isEmpty()) {
            listSales = saleRepo.findByName(filter);
        } else {
            listSales = saleRepo.findAll();
        }

        model.addAttribute("filter", filter);
        model.addAttribute("listSales", listSales);

        return "sales";
    }

    @GetMapping("/sales/edit/{id}")
    public String showEditSaleForm(@PathVariable("id") Integer id, Model model) {
        Sale sale = saleRepo.findById(id).get();

        List<OtherKorm> listOther = otherKormRepo.findAll();
        List<Concentrate> listConcentrates = concentrateRepo.findAll();
        List<Combicorm> listCombicorms = combicormRepo.findAll();
        List<FoodForCatAndDog> listFoods = foodRepo.findAll();
        List<Grain> listGrain = grainRepo.findAll();

        model.addAttribute("sale", sale);

        model.addAttribute("listOther", listOther);
        model.addAttribute("listConcentrates", listConcentrates);
        model.addAttribute("listCombicorms", listCombicorms);
        model.addAttribute("listFoods", listFoods);
        model.addAttribute("listGrain", listGrain);

        return "sales_form";
    }

    @GetMapping("/sales/delete/{id}")
    public String showDeleteSaleForm(@PathVariable("id") Integer id, Model model) {
        saleRepo.deleteById(id);

        return "redirect:/sales";
    }
}
