package com.mit.curd.controller;

import com.mit.curd.entity.Country;
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
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        Country createCount = countryService.createCountry(country);
        System.out.println("Country details : " + createCount);
        return new ResponseEntity<>(createCount, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Country> updateCountryData(@PathVariable("id") long cId, @RequestBody Country country) {
        Country updateData = countryService.updateCountry(cId, country);
        return new ResponseEntity<>(updateData, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountry() {
        List<Country> countryList = countryService.getAllCountry();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getStudentById(@PathVariable("id") long cId) {
        Country c = countryService.getCountryById(cId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable("id") long cId) {
        String deletedMessage = countryService.deleteCountry(cId);
        return new ResponseEntity<>(deletedMessage, HttpStatus.OK);
    }

}


