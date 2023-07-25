package com.project.sushipizzabar.categories.controllers;

import com.project.sushipizzabar.categories.CategoryService;
import com.project.sushipizzabar.food.dao.FoodRepository;
import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.food.model.FoodType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/{foodType}")
    public ResponseEntity<List<Food>> getFoodsByTypeName(@PathVariable String foodType, @RequestParam int pageNumber, @RequestParam int foodCount) {
        return ResponseEntity.ok(categoryService.getFoodByPageNumber(foodType, QPageRequest.of(pageNumber, foodCount)));
    }


}
