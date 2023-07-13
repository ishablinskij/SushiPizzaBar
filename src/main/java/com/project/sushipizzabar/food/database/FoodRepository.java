package com.project.sushipizzabar.food.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findById(int id);

    List<Food> findByName(String name);


}
