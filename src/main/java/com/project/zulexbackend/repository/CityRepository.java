package com.project.zulexbackend.repository;

import com.project.zulexbackend.http.request.CityRequest;
import com.project.zulexbackend.model.Canton;
import com.project.zulexbackend.model.City;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class CityRepository {

    private JdbcTemplate jdbcTemplate;

    public City createCity(CityRequest cityRequest) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("City").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new java.util.HashMap<>(Map.of(
                "name", cityRequest.getName(),
                "cantonId", cityRequest.getCantonId()));

        Integer cityId = jdbcInsert.executeAndReturnKey(parameters).intValue();

        return new City(cityId, cityRequest.getCantonId(), cityRequest.getName(), Collections.emptyList());

    }

    public List<City> getCitiesForCanton(Integer cantonId) {
        return jdbcTemplate.query(String.format("SELECT id, name FROM City WHERE cantonId = %d", cantonId), new BeanPropertyRowMapper(City.class));
    }

    public int deleteCity(Integer cityId) {
        return jdbcTemplate.update(String.format("DELETE FROM City WHERE id=%d", cityId));
    }

    public City updateCity(Integer cityId, CityRequest cityRequest) {
        deleteCity(cityId);
        return createCity(cityRequest);
    }
}
