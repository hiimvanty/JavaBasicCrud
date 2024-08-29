package com.devcamp.api.task_64dot30_crud_drinks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_64dot30_crud_drinks.models.CDrink;

public interface IDrinkRepository extends JpaRepository<CDrink, Long> {

}
