package com.project.sushipizzabar.basket.dto;

import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.users.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketDto {

    private int id;

    private User user;

    private List<Food> foods;

}