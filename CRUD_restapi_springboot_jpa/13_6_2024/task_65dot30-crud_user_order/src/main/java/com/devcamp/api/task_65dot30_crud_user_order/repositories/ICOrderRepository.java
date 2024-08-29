package com.devcamp.api.task_65dot30_crud_user_order.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_65dot30_crud_user_order.models.COrder;

public interface ICOrderRepository extends JpaRepository<COrder, Long> {
    List<COrder> findBycUserId(Long id);
}
