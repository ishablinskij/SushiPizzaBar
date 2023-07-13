package com.project.sushipizzabar.users.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Basket findById(int id);

    Basket findByUser(User user);
}
