package com.example.hw_tuesday.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ApiResponse {
    private String message;
    private Integer status;
}
