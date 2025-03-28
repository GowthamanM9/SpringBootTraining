package com.training.spring.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class OwnUserDetailConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("Gowthaman").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("USER").build());
        userDetailsManager.createUser(User.withUsername("Admin").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("ADMIN").build());
        userDetailsManager.createUser(User.withUsername("Client").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("CLIENT").build());

        return userDetailsManager;
    }
}
