package com.example.springlamiapizzeriacrud.api;

import com.example.springlamiapizzeriacrud.controller.PizzaController;
import com.example.springlamiapizzeriacrud.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaRestController {

    @Autowired
    private PizzaController pizzaController;

    @GetMapping
    public List<Pizza> list() {
        return null;
    }
}
