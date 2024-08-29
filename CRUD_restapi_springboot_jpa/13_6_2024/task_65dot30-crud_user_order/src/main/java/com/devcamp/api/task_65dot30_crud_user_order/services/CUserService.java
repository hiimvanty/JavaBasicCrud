package com.devcamp.api.task_65dot30_crud_user_order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_65dot30_crud_user_order.models.CUser;
import com.devcamp.api.task_65dot30_crud_user_order.repositories.ICUserRepository;

@Service
public class CUserService {
    @Autowired
    ICUserRepository pUserRepository;

    public List<CUser> getAllUser() {
        return pUserRepository.findAll();
    }

    public Optional<CUser> getUserByUserId(Long id) {
        return pUserRepository.findById(id);
    }

    public CUser createUser(CUser user) {
        return pUserRepository.save(user);
    }

    public CUser updateUser(CUser user) {
        return pUserRepository.save(user);
    }

    public void deletaUserById(Long id) {
        pUserRepository.deleteById(id);
    }
}
