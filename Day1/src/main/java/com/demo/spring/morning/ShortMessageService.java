package com.demo.spring.day1.morning;

public class ShortMessageService implements NotificationService {

	@Override
	public void notify(String message) {
		System.out.println("SMS: "+"Order Processed..");

	}

}
