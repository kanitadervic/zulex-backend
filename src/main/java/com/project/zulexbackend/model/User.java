package com.project.zulexbackend.model;

import com.project.zulexbackend.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;
    private UserRole role;
}
