package com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.models.CCarType;

public interface ICarTypeRepository extends JpaRepository<CCarType, Integer> {

}
