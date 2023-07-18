package com.project.sushipizzabar.categories.controllers;

import com.project.sushipizzabar.food.dao.FoodRepository;
import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.food.model.FoodType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final FoodRepository foodRepository;

    public CategoryController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("/{foodType}")
    public ResponseEntity<List<Food>> getFoodsByTypeName(@PathVariable String foodType) {
        return ResponseEntity.ok(foodRepository.findByType(FoodType.getByName(foodType)));
    }
}
