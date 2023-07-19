package com.project.sushipizzabar.users.dao;

import com.project.sushipizzabar.users.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address getAddressById(Integer id);

    Address getAddressByUserId(Integer id);


}
