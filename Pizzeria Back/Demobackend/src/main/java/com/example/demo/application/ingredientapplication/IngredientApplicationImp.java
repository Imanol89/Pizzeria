package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;
import com.example.demo.domain.ingredientdomain.IngredientService;
import com.example.demo.dto.ingredientdtos.CreateOrUpdateIngredientDTO;
import com.example.demo.dto.ingredientdtos.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp implements IngredientApplication {
    
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto){
        //input: entra el dTO
        Ingredient ingredient = IngredientService.create(dto);
        //Conexión de aplicación y repositorio // ingrediente
        this.ingredientRepository.add(ingredient); //-> se guarda en el repositorio
        //Output: sale otro DTO
        return IngredientService.createDTO(ingredient); //--> Este DTO se lo pasa al controlador
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void update(UUID id, CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        this.ingredientRepository.update(ingredient);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        this.ingredientRepository.delete(ingredient);
    }

    public List<IngredientProjection> getAll(String name,  int page, int size){
        return this.ingredientRepository.getAll(name, page, size);
    }
}