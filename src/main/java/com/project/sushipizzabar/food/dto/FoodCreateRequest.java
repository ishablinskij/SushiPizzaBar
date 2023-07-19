package com.project.sushipizzabar.food.dto;

import com.project.sushipizzabar.food.model.Food;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCreateRequest {

    private int basketId;

    private Food food;
}
