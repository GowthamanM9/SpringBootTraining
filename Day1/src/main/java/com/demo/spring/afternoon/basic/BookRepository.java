package com.demo.spring.day1.afternoon.basic;


import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements DataRepository {

    public String save(Book bk){
        return bk.toString();
    }
}
