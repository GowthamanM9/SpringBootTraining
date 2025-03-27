package com.training.spring_boot.library_service.service;

import com.training.spring_boot.library_service.dto.BookDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LibraryService {

    RestClient.Builder restClientBuilder;

    @Autowired
    public LibraryService(RestClient.Builder restClientBuilder){
        this.restClientBuilder = restClientBuilder;
    }

    @CircuitBreaker(name = "backendB", fallbackMethod = "fallbackGetBook")
    public BookDto GetBook(String isbn){
        BookDto book = this.restClientBuilder.build()
                .get()
                .uri("http://book-service/books/{isbn}", isbn)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BookDto.class);

        return book;
    }

    public BookDto fallbackGetBook(Exception ex){
        throw new RuntimeException("Books service is down");
    }
}
