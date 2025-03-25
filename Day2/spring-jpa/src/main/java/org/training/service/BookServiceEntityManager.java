package org.training.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import org.training.dao.Book;

@Service
public class BookServiceEntityManager {
    @PersistenceContext
    private EntityManager em;

    public void showAllBooks() {
        Query query = em.createQuery("select book from Book as book");
        List<Book> books = query.getResultList();

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
