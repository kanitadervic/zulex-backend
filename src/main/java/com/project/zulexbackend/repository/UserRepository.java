package com.project.zulexbackend.repository;

import com.project.zulexbackend.model.User;
import com.project.zulexbackend.service.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public UserDetails findByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = jdbcTemplate.queryForObject(String.format("SELECT * FROM User WHERE username='%s'", username),
                    new BeanPropertyRowMapper<>(User.class));

            System.out.println(user);
            return UserDetailsImpl.build(user);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
