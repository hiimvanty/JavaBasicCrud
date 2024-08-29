package com.devcamp.api.task69dot80.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task69dot80.models.CClass;

public interface IClassRepository extends JpaRepository<CClass, Long> {

}
