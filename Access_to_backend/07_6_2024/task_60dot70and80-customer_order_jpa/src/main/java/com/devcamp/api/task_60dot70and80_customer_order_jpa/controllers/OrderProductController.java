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
import com.devcamp.api.task_60dot70and80_customer_order_jpa.models.CProduct;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.repository.ICustomerRepository;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.repository.IOrderRepository;
import com.devcamp.api.task_60dot70and80_customer_order_jpa.repository.IProductRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderProductController {
    @Autowired
    ICustomerRepository pCustomerRepository;

    @Autowired
    IOrderRepository pOrderRepository;

    @Autowired
    IProductRepository pProductRepository;

    @GetMapping("/list-products")
    public ResponseEntity<List<CProduct>> getAllProduct() {
        try {
            List<CProduct> listProduct = new ArrayList<CProduct>();
            pProductRepository.findAll().forEach(listProduct::add);
            if (listProduct.size() == 0) {
                return new ResponseEntity<>(listProduct, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(listProduct, HttpStatus.OK);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Set<CProduct>> getProductByOrderId(@RequestParam(value = "orderId") long id) {
        try {
            COrder vOrder = pOrderRepository.findById(id);
            if ((vOrder != null)) {
                return new ResponseEntity<>(vOrder.getProducts(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
