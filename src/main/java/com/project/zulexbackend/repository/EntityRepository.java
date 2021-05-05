package com.project.zulexbackend.repository;

import com.project.zulexbackend.model.Canton;
import com.project.zulexbackend.model.City;
import com.project.zulexbackend.model.Company;
import com.project.zulexbackend.model.Entity;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EntityRepository {

    private JdbcTemplate jdbcTemplate;

    public List<Entity> getAll() {
        List<Entity> entities = jdbcTemplate.query(String.format("SELECT * FROM Entity"),
                new BeanPropertyRowMapper<>(Entity.class));

        entities.forEach(e -> e.setCantons(setCantonsForEntity(e)));

        entities.forEach(e -> e.getCantons().forEach(
                c -> c.setCities(setCitiesForCanton(c))
        ));

//        entities.forEach(e -> e.getCantons().forEach(
//                c -> c.getCities().forEach(
//                        city -> city.setCompanies(setCompaniesForCity(city))
//                )
//        ));

        return entities;
    }

    private List<Company> setCompaniesForCity(City city) {
        return jdbcTemplate.query(String.format("SELECT * FROM Company WHERE cityId = %d", city.getId()),
                new BeanPropertyRowMapper<>(Company.class));
    }

    private List<City> setCitiesForCanton(Canton c) {
        return jdbcTemplate.query(String.format("SELECT * FROM City WHERE cantonId = %d", c.getId()),
                new BeanPropertyRowMapper<>(City.class));
    }

    private List<Canton> setCantonsForEntity(Entity e) {
        return jdbcTemplate.query(String.format("SELECT * FROM Canton WHERE entityId = %d", e.getId()),
                new BeanPropertyRowMapper<>(Canton.class));
    }
}
