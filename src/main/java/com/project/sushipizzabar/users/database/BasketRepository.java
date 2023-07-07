package com.project.sushipizzabar.users.database;

import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {

    Basket findById(int id);

    Basket findByUser(User user);
}
