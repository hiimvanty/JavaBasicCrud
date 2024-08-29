package com.devcamp.api.task_66_crud_province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_66_crud_province.models.CDistrict;
import com.devcamp.api.task_66_crud_province.models.CProvince;

public interface IProvinceRepository extends JpaRepository<CProvince, Integer> {
  
}
