package com.training.controller;

import com.training.dao.Book;
import com.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @GetMapping(path = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookByIsBn(@PathVariable String isbn) {
        return ResponseEntity.ok(this.bookService.findBookById(isbn));
    }
}
