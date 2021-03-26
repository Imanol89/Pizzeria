package com.example.demo.infraestructure.pizzainfraestructure;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaIngredientProjection;
import com.example.demo.domain.pizzadomain.PizzaProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {
    @Query("SELECT p.id as id, p.name as name, p.price as price, p.image as image, p.description as description FROM Pizza p WHERE (:name is NULL OR name LIKE %:name%)")
    List<PizzaProjection> findByCriteria(
        @Param("name") String name,
        Pageable pageable
    );

    @Query("SELECT p FROM Pizza p WHERE id = :id")
    PizzaIngredientProjection findByPizzaId(
        @Param("id") UUID id
    );

}
