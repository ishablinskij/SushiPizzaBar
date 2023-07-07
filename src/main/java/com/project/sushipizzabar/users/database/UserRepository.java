package com.project.sushipizzabar.users.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findById(int id);

    User findByEmail(String email);

    List<User> findAllByFirstName(String firstName);

}
