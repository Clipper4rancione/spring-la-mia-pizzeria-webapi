package com.example.springlamiapizzeriacrud.service;

import com.example.springlamiapizzeriacrud.model.Pizza;
import com.example.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PizzaService {

    @Autowired
    static
    PizzaRepository pizzaRepository;

    public static Pizza createPizza(Pizza pizzaForm) {
        Pizza pizzaToPersist = new Pizza();
        pizzaToPersist.setName(pizzaForm.getName());
        pizzaToPersist.setDescription(pizzaForm.getDescription());
        pizzaToPersist.setPrice(pizzaForm.getPrice());
        pizzaRepository.save(pizzaForm);
        return pizzaToPersist;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll(Sort.by("name"));
    }
}
