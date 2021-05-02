package com.project.zulexbackend.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZulexArrayResponse<T> {
    int statusCode;
    private List<T> entity;
    String message;
}