package com.project.sushipizzabar.food.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private FoodType type;

    @Column
    private BigDecimal cost;

    @Column
    private BigDecimal weight;

    @Enumerated(EnumType.STRING)
    @Column
    private Size size;

    @Column
    private String description;

    @ElementCollection
    private List<String> ingredients;

    @Column
    private String picturePath;


}
