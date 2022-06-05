package ru.bliz.grain_mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bliz.concentrate.Concentrate;
import ru.bliz.sales.Sale;

import java.util.List;

@Controller
public class GrainController {

    @Autowired
    private GrainRepo repo;

    @GetMapping("/grains")
    public String listGrain(Model model) {
        List<Grain> listGrains = repo.findAll();
        model.addAttribute("listGrains", listGrains);

        return "grains";
    }

    @GetMapping("/grains/new")
    public String showGrainNewForm(Model model) {
        model.addAttribute("grain", new Grain());

        return "grain_form";
    }

    @PostMapping("/grains/save")
    public String saveGrain(Grain concentrate) {
        repo.save(concentrate);

        return "redirect:/grains";
    }

    @GetMapping("/grains/edit/{id}")
    public String showEditGrainForm(@PathVariable("id") Integer id, Model model) {
        Grain grain = repo.findById(id).get();
        repo.deleteById(id); // по возможности исправить
        model.addAttribute("grain", grain);

        return "grain_form";
    }

    @GetMapping("/grains/delete/{id}")
    public String showDeleteGrainForm(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);

        return "redirect:/grains";
    }
}
