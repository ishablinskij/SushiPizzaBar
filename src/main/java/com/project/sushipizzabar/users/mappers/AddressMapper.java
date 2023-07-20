package com.project.sushipizzabar.users.mappers;

import com.project.sushipizzabar.users.dto.addressDto.AddressCreateRequest;
import com.project.sushipizzabar.users.dto.addressDto.AddressDto;
import com.project.sushipizzabar.users.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setId(address.getId());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setStreet(address.getStreet());
        return addressDto;
    }

    public Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setStreet(addressDto.getStreet());
        address.setId(addressDto.getId());
        return address;
    }

    public AddressDto toDto(AddressCreateRequest createRequest) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(createRequest.getCity());
        addressDto.setHouseNumber(createRequest.getHouseNumber());
        addressDto.setStreet(createRequest.getStreet());
        return addressDto;
    }

    public Address toAddress(AddressCreateRequest createRequest) {
        Address address = new Address();
        address.setCity(createRequest.getCity());
        address.setHouseNumber(createRequest.getHouseNumber());
        address.setStreet(createRequest.getStreet());
        return address;
    }


}
