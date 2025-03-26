package com.training.spring_boot.rest_client.dto;

import lombok.Data;

@Data
public class BookDto {
    private String isbn;
    private String name;
    private String author;
    private String genre;
}
