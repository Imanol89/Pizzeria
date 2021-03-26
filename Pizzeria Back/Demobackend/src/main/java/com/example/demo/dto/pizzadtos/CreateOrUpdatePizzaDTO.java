package com.example.demo.dto.pizzadtos;


import java.util.HashSet;
import java.util.UUID;

public class CreateOrUpdatePizzaDTO {
    public String name;
    public HashSet<UUID> ingredients;
    public String description;
}
