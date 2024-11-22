package com.kirillkotov.soapspringbootlect.service;

import com.kirillkotov.soapspringbootlect.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {
    void add(Country country);

    List<Country> getAll();

    Country getByName(String name);
    List<Country> getByPopulation(int population);
}
