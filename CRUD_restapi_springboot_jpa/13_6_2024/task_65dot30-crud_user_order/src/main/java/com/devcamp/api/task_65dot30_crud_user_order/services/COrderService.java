package com.devcamp.api.task_65dot30_crud_user_order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_65dot30_crud_user_order.models.COrder;
import com.devcamp.api.task_65dot30_crud_user_order.repositories.ICOrderRepository;

@Service
public class COrderService {
    @Autowired
    ICOrderRepository pOrderRepository;

    public List<COrder> getAllOrder() {
        return pOrderRepository.findAll();
    }

    public List<COrder> getOrderByUserId(Long userId) {
        return pOrderRepository.findBycUserId(userId);
    }

    public Optional<COrder> getOrderByOrderId(Long id) {
        return pOrderRepository.findById(id);
    }

    public COrder createOrder(COrder region) {
        return pOrderRepository.save(region);
    }

    public COrder updateOrder(COrder region) {
        return pOrderRepository.save(region);
    }

    public void deleteOrderById(Long id) {
        pOrderRepository.deleteById(id);
    }
}
