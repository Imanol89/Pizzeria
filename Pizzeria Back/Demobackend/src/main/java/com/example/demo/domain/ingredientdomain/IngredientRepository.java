package com.example.demo.domain.ingredientdomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository {
    public void add(Ingredient ingredient);
    public Optional<Ingredient> findById(UUID id);
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);
    public List<IngredientProjection> getAll(String name, int page, int size);
}
// Dominio -> infraestructura(repositorio) -> Dtos -> Servicio(Aplicacion) -> controlador