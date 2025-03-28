package com.training.spring.api_gateway.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequestDto {
    private String username;
    private String password;
}
