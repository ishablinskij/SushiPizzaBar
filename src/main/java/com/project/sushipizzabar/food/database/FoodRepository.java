package com.project.sushipizzabar.food.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer> {

    Food findById(int id);

    List<Food> findByName(String name);


}
