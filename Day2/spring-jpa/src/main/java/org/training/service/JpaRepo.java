package org.training.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.training.config.JpaAppConfig;

public class JpaRepo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaAppConfig.class);

//        BookService service=ctx.getBean(BookService.class);
//        service.showAllBooks();

        BookServiceEntityManager serviceEm =ctx.getBean(BookServiceEntityManager.class);
        serviceEm.showAllBooks();
    }
}
