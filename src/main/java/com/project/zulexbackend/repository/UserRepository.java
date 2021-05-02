package com.project.zulexbackend.repository;

import com.project.zulexbackend.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public void register(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("User").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new java.util.HashMap<>(Map.of(
                "name", user.getName(),
                "lastName", user.getLastName(),
                "phone", user.getPhone(),
                "email", user.getEmail(),
                "username", user.getUsername(),
                "password", user.getPassword(),
                "role", user.getRole()));

        jdbcInsert.execute(parameters);

    }
}
