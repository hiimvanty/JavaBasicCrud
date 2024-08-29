package com.devcamp.api.task_65dot30_crud_user_order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_65dot30_crud_user_order.models.CUser;

public interface ICUserRepository extends JpaRepository<CUser, Long> {

}
