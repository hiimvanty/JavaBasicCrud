package com.devcamp.api.task_56ddot40array_integer_filter_request_input.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot40array_integer_filter_request_input.services.ArrayFilterInputService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArrayFilterInputController {
    @Autowired
    private ArrayFilterInputService arrayFilterInputService;

    @GetMapping("/array-int-request-query")
    public ArrayList<Integer> getLargers(@RequestParam int pos){
        return arrayFilterInputService.getLargers(pos);
    }

    @GetMapping("/array-int-param/{index}")
    public Integer getNumberByIndex(@PathVariable int index){
        return arrayFilterInputService.getNumberByIndex(index);
    }
}
