package com.project.sushipizzabar.users.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;

    private String city;

    private String street;

    private int houseNumber;
}
