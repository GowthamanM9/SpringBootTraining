package com.demo.spring.day1.afternoon.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApi {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext((DataConfig.class));

        BookService service = ctx.getBean("bookService", BookService.class);
        Book bk = new Book("1234", "Money Mind", "Gowthaman");
        System.out.println(service.save(bk));
    }
}
