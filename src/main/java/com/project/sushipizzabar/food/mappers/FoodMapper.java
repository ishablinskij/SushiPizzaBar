package com.project.sushipizzabar.food.mappers;

import com.project.sushipizzabar.food.dto.FoodDto;
import com.project.sushipizzabar.food.model.Food;

public class FoodMapper {

    public Food toFood(FoodDto foodDto) {
        Food food = new Food();
        food.setSize(foodDto.getSize());
        food.setDescription(foodDto.getDescription());
        food.setPicturePath(foodDto.getPicturePath());
        food.setCost(foodDto.getCost());
        food.setName(foodDto.getName());
        food.setId(foodDto.getId());
        food.setType(foodDto.getType());
        food.setIngredients(foodDto.getIngredients());
        food.setWeight(foodDto.getWeight());
        return food;
    }

    public FoodDto toDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setSize(food.getSize());
        foodDto.setPicturePath(food.getPicturePath());
        foodDto.setDescription(food.getDescription());
        foodDto.setCost(food.getCost());
        foodDto.setName(food.getName());
        foodDto.setId(food.getId());
        foodDto.setType(food.getType());
        foodDto.setIngredients(food.getIngredients());
        foodDto.setWeight(food.getWeight());
        return foodDto;
    }

}
