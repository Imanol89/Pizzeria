package com.example.demo.application.pizzaapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.PizzaIngredientProjection;
import com.example.demo.domain.pizzadomain.PizzaProjection;
import com.example.demo.dto.commentdtos.CommentDTO;
import com.example.demo.dto.commentdtos.CreateCommentDTO;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);

    public PizzaDTO get(UUID id);

    public void update(UUID id, CreateOrUpdatePizzaDTO dto);

    public void delete(UUID id);

    public CommentDTO addComment(UUID pizzaId, CreateCommentDTO createCommentDTO);

    public void removeIngredient(UUID id, UUID ingredientId);

    public PizzaDTO addIngredient(UUID id, UUID ingredientId);

    public List<PizzaProjection> getAll(String name, int page, int size);

    public PizzaIngredientProjection getPizzaInfo(UUID id);

}
