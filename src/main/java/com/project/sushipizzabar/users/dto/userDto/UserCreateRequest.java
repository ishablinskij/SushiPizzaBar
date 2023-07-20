package com.project.sushipizzabar.users.dto.userDto;

import com.project.sushipizzabar.users.dto.addressDto.AddressCreateRequest;
import lombok.Data;

@Data
public class UserCreateRequest {

    private String telephone;

    private String name;

    private String password;

    private String passwordRetry;

    private AddressCreateRequest address;

}
