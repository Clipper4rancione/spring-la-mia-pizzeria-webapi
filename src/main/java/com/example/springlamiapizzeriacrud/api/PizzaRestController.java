package com.example.springlamiapizzeriacrud.api;

import com.example.springlamiapizzeriacrud.controller.PizzaController;
import com.example.springlamiapizzeriacrud.model.Pizza;
import com.example.springlamiapizzeriacrud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/pizza")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    // LISTA DI TUTTE LE PIZZE

    @GetMapping
    public List<Pizza> list() {
        return pizzaService.getAllPizzas();
    }

    // SHOW DELLA SINGOLA PIZZA
    @GetMapping("/{id}")
    public Pizza getById(@PathVariable Integer id) {
        try {
            return pizzaService.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // CREATE DI UNA PIZZA
    @PostMapping
    public Pizza create(@RequestBody Pizza pizza) {
        return pizzaService.createPizza(pizza);
    }

}
