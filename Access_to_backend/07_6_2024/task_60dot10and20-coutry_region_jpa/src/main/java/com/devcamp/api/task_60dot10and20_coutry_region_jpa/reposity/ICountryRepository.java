package com.devcamp.api.task_60dot10and20_coutry_region_jpa.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_60dot10and20_coutry_region_jpa.models.CCountry;

public interface ICountryRepository extends JpaRepository<CCountry, Long> {
    CCountry findByCountryCode(String countryCode);
}
