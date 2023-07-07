package com.project.sushipizzabar.food;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionType;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;

@Getter
@Setter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private FoodType type;

    @Column
    private BigDecimal cost;

    @Column
    private BigDecimal weight;

    @Column
    private BigDecimal size;

    @Column
    private String description;

    @ElementCollection
    private List<String> ingredients;


}
