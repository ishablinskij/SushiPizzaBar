package com.project.sushipizzabar.users.dao;

import com.project.sushipizzabar.users.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findById(int id);

    Role findByName(String name);

}
