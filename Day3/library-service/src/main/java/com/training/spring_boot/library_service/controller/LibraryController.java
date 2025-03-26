package com.training.spring_boot.library_service.controller;

import com.training.spring_boot.library_service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private RestClient.Builder restClientBuilder;

    @GetMapping(path="/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> locateBook(@PathVariable String isbn) {
        BookDto book = this.restClientBuilder.build().get().uri("http://localhost:8080/books/{isbn}", isbn)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BookDto.class);

        return  ResponseEntity.ok(book);
    }
}
