package com.example.demo.domain.ingredientdomain;
import java.util.UUID;

import com.example.demo.dto.ingredientdtos.CreateOrUpdateIngredientDTO;
import com.example.demo.dto.ingredientdtos.IngredientDTO;

public class IngredientService {
    //crear el input DTO
    public static Ingredient create(CreateOrUpdateIngredientDTO dto){
        Ingredient ingredient = new Ingredient();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        ingredient.id = UUID.randomUUID();
        return ingredient; //va al repositorio
    }
    //crear el output DTO
    public static IngredientDTO createDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.id = ingredient.id;
        ingredientDTO.name = ingredient.name;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO; // ---> controlador
    }
}
