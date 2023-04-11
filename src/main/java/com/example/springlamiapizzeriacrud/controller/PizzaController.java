package com.example.springlamiapizzeriacrud.controller;

import com.example.springlamiapizzeriacrud.model.Pizza;
import com.example.springlamiapizzeriacrud.repository.PizzaRepository;
import com.example.springlamiapizzeriacrud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzas;
        pizzas = pizzaService.getAllPizzas();
        model.addAttribute("list", pizzas);
        return "/pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        try {
            Pizza pizza = pizzaService.findById(id);
            model.addAttribute("pizza", pizza);
            return "/pizzas/show";
        } catch (RuntimeException e) {
            throw new RuntimeException("Book with id \" + id + \" not found");
        }

    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "/pizzas/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("pizza") Pizza pizzaForm) {

        pizzaService.createPizza(pizzaForm);
        return "redirect:/pizzas";
    }
}
