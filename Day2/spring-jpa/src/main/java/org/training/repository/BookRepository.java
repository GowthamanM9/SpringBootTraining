package org.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.training.dao.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
