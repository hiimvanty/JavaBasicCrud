package com.devcamp.api.task_60dot70and80_customer_order_jpa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_60dot70and80_customer_order_jpa.models.CCustomer;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.models.COrder;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.repository.ICustomerRepository;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.repository.IOrderRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerOrderController {
    @Autowired
    ICustomerRepository pCustomerRepository;

    @Autowired
    IOrderRepository pOrderRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<CCustomer>> getAllCustomers() {
        try {
            List<CCustomer> listCustomer = new ArrayList<CCustomer>();
            pCustomerRepository.findAll().forEach(listCustomer::add);
            if (listCustomer.size() == 0) {
                return new ResponseEntity<>(listCustomer, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(listCustomer, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("list-order")
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

    @GetMapping("/orders")
    public ResponseEntity<Set<COrder>> getOrderByCustomerId(@RequestParam(value = "customer-id") long id) {
        try {
            CCustomer vCustomer = pCustomerRepository.findById(id);
            if (vCustomer != null) {
                return new ResponseEntity<>(vCustomer.getOrders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
