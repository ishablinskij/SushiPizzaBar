package com.project.sushipizzabar.users.database;

import com.project.sushipizzabar.food.database.Food;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class BasketFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "basket_id")
    private int basketId;

    @Column(name = "food_id")
    private int foodId;


}
