package com.devcamp.api.task_56ddot40array_integer_filter_request_input.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ArrayFilterInputService {
    private int[] largerNumbers = { 1, 23, 32, 43, 54, 65, 86, 10, 15, 16, 18 };

    public ArrayList<Integer> getLargers(int pos) {
        ArrayList<Integer> getArrayLargers = new ArrayList<>();
        for (Integer item : largerNumbers) {
            if (item > pos) {
                getArrayLargers.add(item);
            }
        }
        return getArrayLargers;
    }

    public Integer getNumberByIndex(int index) {
        if (index >= 0 && index < largerNumbers.length) {
            return largerNumbers[index];
        }
        return null;
    }   
}
