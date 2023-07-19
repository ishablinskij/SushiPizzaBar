package com.project.sushipizzabar.users.dto;

import lombok.Data;

@Data
public class AddressCreateRequest {

    private String city;

    private String street;

    private int houseNumber;
}
