package com.demo.spring.day1.morning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWIthSpringDI {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		UserService userSRService=(UserService)ctx.getBean("userService");
		
		userSRService.sendMessage("Order Delivered..");
		
		
		UserService userService1=(UserService)ctx.getBean("userService");
		
		System.out.println(userSRService==userService1);
		
		

	}

}
