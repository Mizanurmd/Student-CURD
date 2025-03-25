package com.mit.curd.service;

import com.mit.curd.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    public AddressDTO getAddress(int id);

    public AddressDTO addAddress(AddressDTO address);

    public AddressDTO updateAddress(int id, AddressDTO address);

    public AddressDTO deleteAddress(int id);

    public List<AddressDTO> getAllAddress();
}
