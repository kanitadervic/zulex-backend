package com.project.zulexbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    private Integer id;
    private String name;
    private List<Canton> cantons;
}
