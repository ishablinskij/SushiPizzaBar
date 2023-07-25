package com.project.sushipizzabar.users.dao;

import com.project.sushipizzabar.users.model.auth.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {


}
