package com.devcamp.api.task_56ddot10rainbow_request_input.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot10rainbow_request_input.services.RainbowService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RainbowsController {
    @Autowired
    RainbowService rainbowService;

    @GetMapping("/rainbows-restapi")
    public ArrayList<String> filterRainbow(@RequestParam(value = "q", defaultValue = "") String keyword) {
        ArrayList<String> rainbows = new ArrayList<>();
        rainbows = rainbowService.filterRainbows(keyword);
        return rainbows;
    }

    @GetMapping("/rainbows-request-param/{index}")
    public String getRainbow(@PathVariable int index){
return rainbowService.getRainbows(index);
    }
    
}
