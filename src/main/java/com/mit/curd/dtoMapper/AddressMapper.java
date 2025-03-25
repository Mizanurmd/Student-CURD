package com.mit.curd.dtoMapper;

import com.mit.curd.dto.AddressDTO;
import com.mit.curd.entity.Address;

public class AddressMapper {
    public static AddressDTO toAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setZip(address.getZip());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }
}
