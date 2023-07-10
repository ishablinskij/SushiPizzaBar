package com.project.sushipizzabar.users.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Basket findById(int id);

    Basket findByUser(User user);
}
