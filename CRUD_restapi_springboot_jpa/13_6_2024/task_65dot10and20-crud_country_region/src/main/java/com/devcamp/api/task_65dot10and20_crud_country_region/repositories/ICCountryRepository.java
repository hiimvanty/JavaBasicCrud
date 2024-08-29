package com.devcamp.api.task_65dot10and20_crud_country_region.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_65dot10and20_crud_country_region.models.CCountry;

public interface ICCountryRepository extends JpaRepository<CCountry, Long> {
    CCountry findByCountryCode(String countryCode);
}
