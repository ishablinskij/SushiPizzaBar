package com.project.sushipizzabar.basket.dao;

import com.project.sushipizzabar.basket.model.Basket;
import com.project.sushipizzabar.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Basket findById(int id);

    Basket findByUser(User user);
}
