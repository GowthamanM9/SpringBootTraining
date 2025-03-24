package com.demo.spring.afternoon.jdbc1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring.day1.afternoon.jdbc")
public class JdbcAppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/libraryDb");
        ds.setUsername("root");
        ds.setPassword("P@ssword");

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        JdbcTemplate jt = new JdbcTemplate(ds);
        return jt;
    }

    @Bean
    public JdbcClient jdbcClient(DataSource ds) {
        JdbcClient client = JdbcClient.create(ds);
        return client;
    }
}
