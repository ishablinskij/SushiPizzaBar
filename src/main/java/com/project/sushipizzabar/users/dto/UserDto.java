package com.project.sushipizzabar.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDto {

    private int id;

    private String name;

    private BigDecimal balance;

    private String telephone;

    private char[] password;

}