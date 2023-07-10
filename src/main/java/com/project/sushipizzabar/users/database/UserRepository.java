package com.project.sushipizzabar.users.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByTelephone(String telephone);

    List<User> findAllByFirstName(String firstName);

}
