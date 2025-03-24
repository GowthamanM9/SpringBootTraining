package com.demo.spring.day1.morning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.demo.spring.day1.morning")
public class AppConfig {

	@Bean
	public NotificationService smsBean() {
		return new ShortMessageService();
	}
}
