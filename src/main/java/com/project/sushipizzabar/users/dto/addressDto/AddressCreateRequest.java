package com.project.sushipizzabar.users.dto.addressDto;

import lombok.Data;

@Data
public class AddressCreateRequest {

    private String city;

    private String street;

    private int houseNumber;
}
