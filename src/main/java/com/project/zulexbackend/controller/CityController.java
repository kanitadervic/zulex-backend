package com.project.zulexbackend.controller;

import com.project.zulexbackend.http.request.CityRequest;
import com.project.zulexbackend.http.response.ZulexArrayResponse;
import com.project.zulexbackend.http.response.ZulexResponse;
import com.project.zulexbackend.model.City;
import com.project.zulexbackend.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @PostMapping("/city")
    public ZulexResponse<City> createCity(@RequestBody CityRequest cityRequest) {
        City addedCity = cityService.createCity(cityRequest);

        return new ZulexResponse<>(200, addedCity, "OK");
    }

    @GetMapping("/cities")
    public ZulexArrayResponse<City> getCitiesForCanton(@RequestParam("cantonId") Integer cantonId) {
        List<City> citiesForCanton = cityService.getCitiesForCanton(cantonId);

        return new ZulexArrayResponse<>(200, citiesForCanton, "OK");
    }

    @DeleteMapping("/city")
    public ResponseEntity<Integer> deleteCity(@RequestParam("cityId") Integer cityId) {
        int isRemoved = cityService.deleteCity(cityId);

        if (isRemoved != 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cityId, HttpStatus.OK);
    }

    @PutMapping("/city")
    public ZulexResponse<City> updateCity(@RequestParam("cityId") Integer cityId, @RequestBody CityRequest cityRequest) {
        City updatedCity = cityService.updateCity(cityId, cityRequest);

        return new ZulexResponse<>(200, updatedCity, "OK");
    }
}
