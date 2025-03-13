package com.mit.curd.service;

import com.mit.curd.entity.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);

    Country updateCountry(long cId, Country country);

    Country getCountryById(long cId);

    List<Country> getAllCountry();

    String deleteCountry(long cId);


}