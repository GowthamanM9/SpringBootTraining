package com.training.spring.api_gateway.controller;

import com.training.spring.api_gateway.jwt.utils.AuthRequest;
import com.training.spring.api_gateway.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenicateManager;

    @Autowired
    JwtUtil jwtUtil;
    ;

    @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String authenticate(@RequestBody AuthRequest request) throws Exception {
        try {
            authenicateManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
            ));
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }

        return jwtUtil.generateToken(request.getUsername());
    }
}
