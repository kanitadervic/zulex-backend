package com.project.zulexbackend.service;

import com.project.zulexbackend.model.Entity;
import com.project.zulexbackend.repository.EntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {

    private EntityRepository entityRepository;

    public List<Entity> getAll() {
        return entityRepository.getAll();
    }
}
