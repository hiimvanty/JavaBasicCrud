package com.devcamp.api.task_64dot10_crud_vouchers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task_64dot10_crud_vouchers.models.CVoucher;

public interface IVoucherRepository extends JpaRepository<CVoucher, Long> {

}
