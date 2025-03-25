package com.demo.spring.afternoon.basic;

public class Book {
    private final String BkNo;
    private final String Name;
    public final String Author;

    public Book(String bkNo, String name, String author) {
        this.BkNo = bkNo;
        this.Name = name;
        this.Author = author;
    }

    public String getBkNo(){
        return BkNo;
    }

    public String getName(){
        return Name;
    }

    public String getAuthor(){
        return Author;
    }

    @Override
    public String toString() {
        return "Book: No - "+getBkNo() +";Name - "+ getName() +"; Author - "+ getAuthor();
    }
}
