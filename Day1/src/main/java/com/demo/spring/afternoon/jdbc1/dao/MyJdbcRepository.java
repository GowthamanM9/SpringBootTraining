package com.demo.spring.afternoon.jdbc1.dao;

import java.util.List;

public interface MyJdbcRepository {

    public List<Book> findAll();
    public Book save(Book book);
    public Book update(Book book);
    public void delete(String isbn);
    public Book findById(String isbn);

}
