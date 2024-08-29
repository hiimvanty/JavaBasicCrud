package com.devcamo.api.task_59dot20_order_list_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamo.api.task_59dot20_order_list_jpa.models.COrder;

public interface IOrderRepository extends JpaRepository<COrder, Long>{

}
