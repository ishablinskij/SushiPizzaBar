package com.project.sushipizzabar.food.dto;

import com.project.sushipizzabar.food.model.FoodType;
import com.project.sushipizzabar.food.model.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class FoodDto {

    private int id;

    private String name;

    private FoodType type;

    private BigDecimal cost;

    private BigDecimal weight;

    private Size size;

    private String description;

    private List<String> ingredients;

}
