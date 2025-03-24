package com.demo.spring.day1.morning;

public class UserServiceMain {

	public static void main(String[] args) {
		
		NotificationService notificationService=new EmailService();
		
		UserService userService=new UserService(notificationService);
		
		userService.sendMessage("order in process..");

	}

}
