package com.devcamp.api.task_66_crud_province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_66_crud_province.models.CWard;

public interface IWardRepository extends JpaRepository<CWard, Integer> {
    List<CWard> findByDistrictId(Integer Id);
}
