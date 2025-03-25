package com.demo.spring.afternoon.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApi {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext((DataConfig.class));

        BookService service = ctx.getBean("bookService", BookService.class);
        Book bk = new Book("1235", "Money Mind2", "Gowthaman2");
        System.out.println(service.save(bk));
    }
}
