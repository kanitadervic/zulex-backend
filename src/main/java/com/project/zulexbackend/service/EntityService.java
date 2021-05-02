package com.project.zulexbackend.service;

import com.project.zulexbackend.repository.EntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntityService {

    private EntityRepository entityRepository;

    public void getAll() {
        entityRepository.getAll();
    }
}
