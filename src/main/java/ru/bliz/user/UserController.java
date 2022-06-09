package ru.bliz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "userList";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteUserForm(@PathVariable("id") Integer id, Model model) {
        userRepo.deleteById(id);

        return "redirect:/user";
    }
}
