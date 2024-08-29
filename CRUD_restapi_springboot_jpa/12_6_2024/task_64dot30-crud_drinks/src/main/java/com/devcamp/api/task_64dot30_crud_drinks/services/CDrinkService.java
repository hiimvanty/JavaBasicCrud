package com.devcamp.api.task_64dot30_crud_drinks.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_64dot30_crud_drinks.models.CDrink;
import com.devcamp.api.task_64dot30_crud_drinks.repositories.IDrinkRepository;

@Service
public class CDrinkService {
    @Autowired
    private IDrinkRepository pDrinkRepository;

    public List<CDrink> getAllDrinks() {
        return pDrinkRepository.findAll();
    }

    public Optional<CDrink> getDrinkById(long id) {
        return pDrinkRepository.findById(id);
    }

    public CDrink createVoucher(CDrink newCDrink) {
        return pDrinkRepository.save(newCDrink);
    }

    public CDrink updateDrink(CDrink drink) {
        return pDrinkRepository.save(drink);
    }

    public void deleteDrinkById(long id) {
        pDrinkRepository.deleteById(id);
    }
}
