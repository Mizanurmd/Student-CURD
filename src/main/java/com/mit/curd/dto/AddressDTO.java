package com.mit.curd.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
