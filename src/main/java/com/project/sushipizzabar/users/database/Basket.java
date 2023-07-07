package com.project.sushipizzabar.users.database;

import com.project.sushipizzabar.food.database.Food;
import com.project.sushipizzabar.users.database.User;
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

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private List<Food> foodList;

}
