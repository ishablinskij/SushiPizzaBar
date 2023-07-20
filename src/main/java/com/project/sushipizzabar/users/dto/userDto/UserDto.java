package com.project.sushipizzabar.users.dto.userDto;

import com.project.sushipizzabar.users.model.Address;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDto {

    private int id;

    private String name;

    private BigDecimal balance;

    private String telephone;

    private char[] password;

    private Address address;

}