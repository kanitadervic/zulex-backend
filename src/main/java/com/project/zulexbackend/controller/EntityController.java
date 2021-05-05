package com.project.zulexbackend.controller;

import com.project.zulexbackend.http.response.ZulexResponse;
import com.project.zulexbackend.model.Entity;
import com.project.zulexbackend.service.EntityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/entity")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
public class EntityController {

    private EntityService entityService;

    @GetMapping("/getAll")
    public ZulexResponse<List<Entity>> getAll() {
        List<Entity> entities = entityService.getAll();

        return new ZulexResponse(200, entities, "OK");
    }

    @GetMapping("/")
    public ZulexResponse test() {
        System.out.println("tett");
        return new ZulexResponse(200, Collections.EMPTY_LIST, "OK");
    }

}
