package com.devcamp.api.task_56cdot10_country_region.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot10_country_region.models.Region;
import com.devcamp.api.task_56cdot10_country_region.services.RegionService;

@RestController
@RequestMapping("/api")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/region-info")
    public Region getRegionInfo(@RequestParam String regionCode) {
        return regionService.getRegionByRegionCode(regionCode);
    }
}
