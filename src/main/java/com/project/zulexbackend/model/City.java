package com.project.zulexbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private Integer cantonId;
    private String name;
    private List<Company> companies;
}
