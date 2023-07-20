package com.project.sushipizzabar.users.dto.userDto;

import com.project.sushipizzabar.users.dto.addressDto.AddressCreateRequest;
import lombok.Data;

@Data
public class UserCreateRequest {

    private String telephone;

    private String name;

    private char[] password;

    private char[] passwordRetry;

    private AddressCreateRequest address;

}
