package com.project.sushipizzabar.food.model;

import lombok.SneakyThrows;

public enum FoodType {
    SUSHI,
    ROLLS,
    PIZZA;

    @SneakyThrows
    public static FoodType getByName(String name) {
        for (FoodType foodType : FoodType.values()) {
            if (foodType.name().equalsIgnoreCase(name)) {
                return foodType;
            }
        }
        throw new IllegalArgumentException();
    }

}
