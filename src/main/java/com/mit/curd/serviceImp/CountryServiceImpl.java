package com.mit.curd.serviceImp;

import com.mit.curd.customExeption.CountryNotFoundException;
import com.mit.curd.entity.Country;
import com.mit.curd.repository.CountryRepository;
import com.mit.curd.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;

    }

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(long cId, Country country) {
        Country existingCountry = countryRepository.findById(cId)
                .orElseThrow(() -> new CountryNotFoundException("Country with ID : " + cId + " is not founded."));
        existingCountry.setcCode(country.getcCode());
        existingCountry.setCountry_name(country.getCountry_name());
        existingCountry.setCurrency_name(country.getCurrency_name());
        existingCountry.setLanguage(country.getLanguage());
        existingCountry.setNationality(country.getNationality());



        return countryRepository.save(existingCountry);
    }

    @Override
    public Country getCountryById(long cId) {
        return countryRepository.findById(cId)
                .orElseThrow(() -> new CountryNotFoundException("Country with ID : " + cId + " is not found."));
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public String deleteCountry(long cId) {
        Country country = countryRepository.findById(cId)
                .orElseThrow(() -> new CountryNotFoundException("Country With ID : " + cId + " is not founded."));
        countryRepository.delete(country);
        return "Country with " + cId + " Has been successfully deleted.";
    }
}
