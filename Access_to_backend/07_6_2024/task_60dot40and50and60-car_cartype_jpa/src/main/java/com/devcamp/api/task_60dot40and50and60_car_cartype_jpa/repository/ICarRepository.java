package com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.models.CCar;

public interface ICarRepository extends JpaRepository<CCar, Integer> {
    CCar findByCarCode(String carCode);

}
