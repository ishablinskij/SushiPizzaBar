package com.project.sushipizzabar.users.dto.addressDto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;

    private String city;

    private String street;

    private int houseNumber;
}
