package com.devcamp.api.task_65dot30_crud_user_order.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_65dot30_crud_user_order.models.COrder;
import com.devcamp.api.task_65dot30_crud_user_order.models.CUser;
import com.devcamp.api.task_65dot30_crud_user_order.services.COrderService;
import com.devcamp.api.task_65dot30_crud_user_order.services.CUserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class COrderController {
    @Autowired
    COrderService pCOrderService;

    @Autowired
    CUserService pUserService;

    @GetMapping("/order/all")
    public ResponseEntity<List<COrder>> getAllOrder() {
        try {
            return new ResponseEntity<List<COrder>>(pCOrderService.getAllOrder(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}/orders")
    public ResponseEntity<List<COrder>> getOrderByUserId(@PathVariable(value = "userId") Long userId) {
        try {
            return new ResponseEntity<List<COrder>>(pCOrderService.getOrderByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/orders/detail/{id}")
    public ResponseEntity<COrder> getOrderByOrderId(@PathVariable("id") Long id) {
        try {
            Optional<COrder> orderData = pCOrderService.getOrderByOrderId(id);
            if (orderData.isPresent()) {
                return new ResponseEntity<COrder>(orderData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/order/create/{id}")
    public ResponseEntity<Object> createOrder(@PathVariable("id") Long id, @RequestBody COrder order) {
        try {
            Optional<CUser> userData = pUserService.getUserByUserId(id);
            if (userData.isPresent()) {
                COrder newOrder = new COrder();
                newOrder.setOrderCode(order.getOrderCode());
                newOrder.setPizzaSize(order.getPizzaSize());
                newOrder.setPizzaType(order.getPizzaType());
                newOrder.setVoucherCode(order.getVoucherCode());
                newOrder.setPrice(order.getPrice());
                newOrder.setPaid(order.getPaid());

                Date _now = new Date();
                newOrder.setCreated_at(_now);
                newOrder.setUpdated_at(null);

                CUser _user = userData.get();
                newOrder.setcUser(_user);

                COrder createdOrder = pCOrderService.createOrder(newOrder);
                return new ResponseEntity<Object>(createdOrder, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/order/update/{id}")
    public ResponseEntity<COrder> updateRegion(@PathVariable("id") Long id, @RequestBody COrder order) {
        try {
            Optional<COrder> orderData = pCOrderService.getOrderByOrderId(id);
            if (orderData.isPresent()) {
                COrder newOrder = orderData.get();

                newOrder.setOrderCode(order.getOrderCode());
                newOrder.setPizzaSize(order.getPizzaSize());
                newOrder.setPizzaType(order.getPizzaType());
                newOrder.setVoucherCode(order.getVoucherCode());
                newOrder.setPrice(order.getPrice());
                newOrder.setPaid(order.getPaid());
                newOrder.setUpdated_at(new Date());

                COrder savedOrder = pCOrderService.updateOrder(newOrder);
                return new ResponseEntity<COrder>(savedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<String> deleteRegionById(@PathVariable("id") Long id) {
        try {
            pCOrderService.deleteOrderById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
