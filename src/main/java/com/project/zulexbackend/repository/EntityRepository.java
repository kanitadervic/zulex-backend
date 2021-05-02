package com.project.zulexbackend.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EntityRepository {

    private JdbcTemplate jdbcTemplate;

    public void getAll() {

    }
}
