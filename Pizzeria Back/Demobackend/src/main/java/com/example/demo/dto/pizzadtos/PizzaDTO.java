package com.example.demo.dto.pizzadtos;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class PizzaDTO {
    public UUID id;
    public String name;
    public BigDecimal price;
    public String description;
    public Set<PizzaIngredientDTO> ingredients = new HashSet<PizzaIngredientDTO>();
}
