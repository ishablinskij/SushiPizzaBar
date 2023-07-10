package com.project.sushipizzabar.food.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findById(int id);

    List<Food> findByName(String name);


}
