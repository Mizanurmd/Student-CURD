package com.mit.curd.service;

import com.mit.curd.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    CountryDTO createCountry(CountryDTO country);

    CountryDTO updateCountry(long cId, CountryDTO country);

    Optional<CountryDTO> getCountryById(long cId);

    List<CountryDTO> getAllCountry();

    String deleteCountry(long cId);



}