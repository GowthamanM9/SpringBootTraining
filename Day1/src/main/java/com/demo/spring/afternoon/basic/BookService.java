package com.demo.spring.day1.afternoon.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService  {
    private final BookRepository _repository;

    @Autowired
    public BookService(BookRepository repository){
        _repository = repository;
    }

    public String save(Book bk){
       return _repository.save(bk);
    }
}


