package com.devcamo.api.task_59dot20_order_list_jpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamo.api.task_59dot20_order_list_jpa.models.COrder;
import com.devcamo.api.task_59dot20_order_list_jpa.repository.IOrderRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class COrderController {
    @Autowired
    IOrderRepository pOrderRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<COrder>> getAllOrders() {
        try {
            List<COrder> listOrder = new ArrayList<COrder>();
            pOrderRepository.findAll().forEach(listOrder::add);
            if (listOrder.size() == 0) {
                return new ResponseEntity<>(listOrder, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(listOrder, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
