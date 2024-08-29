package com.devcamp.api.task_60dot70and80_customer_order_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_60dot70and80_customer_order_jpa.models.COrder;

public interface IOrderRepository extends JpaRepository<COrder, Long> {
    COrder findById(long id);
}
