package com.project.zulexbackend.service;

import com.project.zulexbackend.http.request.CityRequest;
import com.project.zulexbackend.model.City;
import com.project.zulexbackend.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public City createCity(CityRequest cityRequest) {
        return cityRepository.createCity(cityRequest);
    }

    public List<City> getCitiesForCanton(Integer cantonId) {
        return cityRepository.getCitiesForCanton(cantonId);
    }

    public int deleteCity(Integer cityId) {
        return cityRepository.deleteCity(cityId);
    }

    public City updateCity(Integer cityId, CityRequest cityRequest) {
        return cityRepository.updateCity(cityId, cityRequest);
    }
}
