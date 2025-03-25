package com.training.service;

import com.training.dao.Book;
import com.training.dao.BookNotExistException;
import com.training.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(String isbn) {
        Optional<Book> bookOp = bookRepository.findById(isbn);
        if (bookOp.isPresent()) {
            return bookOp.get();
        } else {
            throw new BookNotExistException("Book with " + isbn + " not found.");
        }
    }
}
