package com.mit.curd.serviceImp;

import com.mit.curd.customExeption.CountryNotFoundException;
import com.mit.curd.customExeption.DuplicateResourceException;
import com.mit.curd.dto.CountryDTO;
import com.mit.curd.entity.Country;
import com.mit.curd.repository.CountryRepository;
import com.mit.curd.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;

    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO) {
        if (countryRepository.existsBycCode(countryDTO.getcCode())) {
            throw new DuplicateResourceException("Country code '" + countryDTO.getcCode() + "' already exists.");
        }
        Country country = new Country();
        country.setcCode(countryDTO.getcCode());
        country.setCountry_name(countryDTO.getCountry_name());
        country.setCurrency_name(countryDTO.getCurrency_name());
        country.setLanguage(countryDTO.getLanguage());
        country.setNationality(countryDTO.getNationality());

        Country saveCountry = countryRepository.save(country);
        countryDTO.setcId(saveCountry.getcId());
        return countryDTO;
    }

    @Override
    public CountryDTO updateCountry(long cId, CountryDTO countryDTO) {
        Country existingCountry = countryRepository.findById(cId)
                .orElseThrow(() -> new CountryNotFoundException("Country with ID : " + cId + " is not founded."));
        existingCountry.setcCode(countryDTO.getcCode());
        existingCountry.setCountry_name(countryDTO.getCountry_name());
        existingCountry.setCurrency_name(countryDTO.getCurrency_name());
        existingCountry.setLanguage(countryDTO.getLanguage());
        existingCountry.setNationality(countryDTO.getNationality());

        Country updateCountry = countryRepository.save(existingCountry);
        countryDTO.setcId(updateCountry.getcId());
        return countryDTO;
    }

    @Override
    public Optional<CountryDTO> getCountryById(long cId) {
        Optional<Country> country = countryRepository.findById(cId);
        return country.map(this::convertToDTO);
    }

    @Override
    public List<CountryDTO> getAllCountry() {
        return countryRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public String deleteCountry(long cId) {
        Country country = countryRepository.findById(cId)
                .orElseThrow(() -> new CountryNotFoundException("Country With ID : " + cId + " is not founded."));
        countryRepository.delete(country);
        return "Country with " + cId + " Has been successfully deleted.";
    }

    private CountryDTO convertToDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setcId(country.getcId());
        dto.setcCode(country.getcCode());
        dto.setCurrency_name(country.getCurrency_name());
        dto.setLanguage(country.getLanguage());
        dto.setNationality(country.getNationality());

        return dto;
    }


}
