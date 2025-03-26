package com.training.spring_boot.library_service.dto;

import lombok.Data;

@Data
public class BookDto {
    private String isbn;
    private String name;
    private String author;
    private String genre;
}
