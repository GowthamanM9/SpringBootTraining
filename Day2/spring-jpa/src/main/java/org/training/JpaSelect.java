package org.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import org.training.config.JpaAppConfig;
import org.training.dao.Book;

import java.util.List;

public class JpaSelect {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaAppConfig.class);

        EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        try {
            Query jpaQuery = em.createQuery("select book from Book as book where book.isbn='112233'");

            List<Book> books = jpaQuery.getResultList();
            for (Book b : books) {
                System.out.println(b);
            }

            Query query = em.createNativeQuery("select * from book where isbn=112233");

            List<Object[]> resultList = query.getResultList();
            for (Object[] entry : resultList) {
                System.out.println(entry[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
