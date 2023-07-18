package com.project.sushipizzabar.food.dao;

import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.food.model.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findById(int id);

    List<Food> findByName(String name);

    List<Food> findByType(FoodType foodType);

}
