package com.project.zulexbackend.controller;

import com.project.zulexbackend.service.EntityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@AllArgsConstructor
@NoArgsConstructor
public class EntityController {

    private EntityService entityService;

    @GetMapping("/getAll")
    public void getAll() {
        entityService.getAll();
    }

}
