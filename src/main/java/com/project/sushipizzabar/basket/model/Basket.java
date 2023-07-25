package com.project.sushipizzabar.basket.model;

import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.users.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> foods;

    public void addFood(Food food) {
        foods.add(food);
    }
}
