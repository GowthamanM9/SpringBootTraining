package com.training.spring.api_gateway;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Uncomment the following dependency in the pom.xml file: to execute this code
/*<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.8.0</version>
</dependency>*/
public class BCryptEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
    }
}
