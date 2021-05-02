package com.project.zulexbackend.controller;

import com.project.zulexbackend.http.request.RegistrationRequest;
import com.project.zulexbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest registrationRequest) {
        userService.register(registrationRequest);

        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
