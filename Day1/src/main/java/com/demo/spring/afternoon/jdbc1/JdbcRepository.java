package com.demo.spring.afternoon.jdbc1;

import com.demo.spring.afternoon.jdbc1.Config.JdbcAppConfig;
import com.demo.spring.afternoon.jdbc1.dao.Book;
import com.demo.spring.afternoon.jdbc1.dao.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class JdbcRepository {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
        BookRepository repo = ctx.getBean("bookRepository", BookRepository.class);

        // Find all
        for (Book book : repo.findAll()) {
            System.out.println(book);
        }

        // Find by Id
        Optional<Book> bookOp = repo.findById("112233");
        if (bookOp.isPresent()) {
            System.out.println(bookOp.get());
        } else {
            System.out.println("Book not found");
        }
    }
}
