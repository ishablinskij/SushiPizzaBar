package com.project.sushipizzabar.users.dao;

import com.project.sushipizzabar.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByTelephone(String telephone);

    List<User> findAllByName(String name);

}
