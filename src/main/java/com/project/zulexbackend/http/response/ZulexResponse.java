package com.project.zulexbackend.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZulexResponse<T> {
    int statusCode;
    T entity;
    String message;
}
