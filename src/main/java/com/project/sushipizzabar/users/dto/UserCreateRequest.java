package com.project.sushipizzabar.users.dto;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String telephone;

    private String name;

    private char[] password;

}
