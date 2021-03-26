package com.example.demo.infraestructure.pizzainfraestructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaIngredientProjection;
import com.example.demo.domain.pizzadomain.PizzaProjection;
import com.example.demo.domain.pizzadomain.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepositoryImp implements PizzaRepository{
    
   private final PizzaJPARepository pizzaJPARepository;
   
   @Autowired
   public PizzaRepositoryImp(final PizzaJPARepository pizzaJPARepository) {
       this.pizzaJPARepository = pizzaJPARepository;
   }

   @Override
   public void add(Pizza pizza) {
       this.pizzaJPARepository.save(pizza);
   }

   @Override
   public Optional<Pizza> findById(UUID id) {
       return this.pizzaJPARepository.findById(id);
   }

   @Override
   public void update(Pizza pizza) {
       this.pizzaJPARepository.save(pizza);
   }

   @Override
   public void delete(Pizza pizza) {
       this.pizzaJPARepository.delete(pizza);
   }

   @Override
    public List<PizzaProjection> getAll(String name, int page, int size) {
       return this.pizzaJPARepository.findByCriteria(
           name,
           PageRequest.of(page, size, Sort.by("name").descending())
       );
    }

    @Override
    public PizzaIngredientProjection getPizzaInfo(UUID id) {
        return this.pizzaJPARepository.findByPizzaId(
           id
       );
    }
}
