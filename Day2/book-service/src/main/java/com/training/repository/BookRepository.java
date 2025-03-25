package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.dao.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
