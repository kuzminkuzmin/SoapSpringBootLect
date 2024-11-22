package com.kirillkotov.soapspringbootlect.repository;

import com.kirillkotov.soapspringbootlect.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    List<Country> findByPopulation(int population);
}
