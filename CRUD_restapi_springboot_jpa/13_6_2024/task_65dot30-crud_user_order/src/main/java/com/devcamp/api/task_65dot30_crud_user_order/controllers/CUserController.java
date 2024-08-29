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

import com.devcamp.api.task_65dot30_crud_user_order.models.CUser;
import com.devcamp.api.task_65dot30_crud_user_order.services.CUserService;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CUserController {
    @Autowired
    CUserService pUserService;

    @GetMapping("/user/all")
    public ResponseEntity<List<CUser>> getAllUser() {
        try {
            return new ResponseEntity<List<CUser>>(pUserService.getAllUser(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/detail/{id}")
    public ResponseEntity<CUser> getUserbyId(@PathVariable("id") Long id) {
        try {
            Optional<CUser> dataUser = pUserService.getUserByUserId(id);
            if (dataUser.isPresent()) {
                return new ResponseEntity<CUser>(dataUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/create")
    public ResponseEntity<CUser> createUser(@RequestBody CUser user) {
        try {
            CUser newUser = new CUser();
            newUser.setFullname(user.getFullname());
            newUser.setEmail(user.getEmail());
            newUser.setPhone(user.getPhone());
            newUser.setAddress(user.getAddress());
            newUser.setOrders(user.getOrders());

            Date _now = new Date();
            newUser.setCreated_at(_now);
            newUser.setUpdated_at(null);

            CUser createdUser = pUserService.createUser(newUser);
            return new ResponseEntity<CUser>(createdUser, HttpStatus.OK);

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<CUser> updateUserById(@PathVariable("id") Long id, @RequestBody CUser user) {
        try {
            Optional<CUser> dataUser = pUserService.getUserByUserId(id);
            if (dataUser.isPresent()) {
                CUser newUser = dataUser.get();
                newUser.setFullname(user.getFullname());
                newUser.setEmail(user.getEmail());
                newUser.setPhone(user.getPhone());
                newUser.setAddress(user.getAddress());
                newUser.setOrders(user.getOrders());
                newUser.setUpdated_at(new Date());

                CUser savedUser = pUserService.updateUser(newUser);
                return new ResponseEntity<CUser>(savedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        try {
            pUserService.deletaUserById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
