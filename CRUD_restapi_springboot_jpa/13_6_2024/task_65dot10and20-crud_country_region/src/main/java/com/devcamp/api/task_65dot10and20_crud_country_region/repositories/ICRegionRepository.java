package com.devcamp.api.task_65dot10and20_crud_country_region.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_65dot10and20_crud_country_region.models.CRegion;

public interface ICRegionRepository extends JpaRepository<CRegion, Long> {
    List<CRegion> findByCountryId(Long countryId);

    Optional<CRegion> findByIdAndCountryId(Long id, Long instructorId);
}
