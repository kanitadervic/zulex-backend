package com.project.zulexbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canton {
    private Integer id;
    private String name;
    private Integer entityId;
    private List<City> cities;
}
