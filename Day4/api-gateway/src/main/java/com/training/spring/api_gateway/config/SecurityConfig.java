package com.training.spring.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(req ->
                req.requestMatchers("/libraries/**").hasRole("USER")
                        .requestMatchers("/books/**").hasRole("ADMIN")
                        .anyRequest()
                        .permitAll());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("Gowthaman").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("USER").build());
        userDetailsManager.createUser(User.withUsername("Admin").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("ADMIN").build());
        userDetailsManager.createUser(User.withUsername("Client").password("$2a$10$qacmMoRmJ8u6UOg/7Ft.8eBImQd3ysZxfCaGzPlu5qwaLEyeZEJJ6").roles("CLIENT").build());

        return  userDetailsManager;
    }
}
