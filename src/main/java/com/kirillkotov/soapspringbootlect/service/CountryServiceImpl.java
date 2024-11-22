package com.kirillkotov.soapspringbootlect.service;

import com.kirillkotov.soapspringbootlect.model.Country;
import com.kirillkotov.soapspringbootlect.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void add(Country country){
        try {
            this.countryRepository.save(country);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Entity already exists!");
        }
    }

    @Override
    public List<Country> getAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getByName(String name) {
        return this.countryRepository.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("Country does not exists!"));
    }

    @Override
    public List<Country> getByPopulation(int population) {
        return this.countryRepository.findByPopulation(population);
    }
}
