package com.demo.spring.day1.morning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {

	private NotificationService notificationService;
	
	
	public void sendMessage(String message) {
		notificationService.notify(message);
	}
	
	//@Autowired
	public UserService(@Qualifier("smsBean") NotificationService notificationService) {
		this.notificationService=notificationService;
		System.out.println("UserService Object Created..");
	}
	
}
