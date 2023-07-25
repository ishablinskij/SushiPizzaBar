package com.project.sushipizzabar.users.model;

import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.users.model.auth.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private BigDecimal balance;

    @Column(unique = true)
    @NotEmpty
    private String telephone;

    @Column(unique = true)
    @NotEmpty
    private String password;

    @ManyToMany
    private List<Role> roles;

    @OneToOne
    private Basket basket;

    public void addRole(Role role) {
        getRoles().add(role);
    }
}
