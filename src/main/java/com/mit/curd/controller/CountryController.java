package com.mit.curd.controller;

import com.mit.curd.customExeption.CountryNotFoundException;
import com.mit.curd.dto.CountryDTO;
import com.mit.curd.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/save")
    public ResponseEntity<CountryDTO> saveCountry(@RequestBody CountryDTO countryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.createCountry(countryDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CountryDTO> updateCountryData(@PathVariable("id") long cId, @RequestBody CountryDTO countryDTO) {
        CountryDTO updateData = countryService.updateCountry(cId, countryDTO);
        return new ResponseEntity<>(updateData, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CountryDTO>> getAllCountry() {
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountry());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getStudentById(@PathVariable("id") long cId) {
        return countryService.getCountryById(cId).map(ResponseEntity::ok)
                .orElseThrow(() -> new CountryNotFoundException("Country with ID : " + cId + " is not found."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable("id") long cId) {
        String deletedMessage = countryService.deleteCountry(cId);
        return new ResponseEntity<>(deletedMessage, HttpStatus.OK);
    }

}


