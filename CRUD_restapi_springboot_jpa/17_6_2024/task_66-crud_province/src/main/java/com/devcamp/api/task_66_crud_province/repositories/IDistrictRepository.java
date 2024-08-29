package com.devcamp.api.task_66_crud_province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_66_crud_province.models.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Integer> {
    List<CDistrict> findByProvinceId(Integer id);
}
