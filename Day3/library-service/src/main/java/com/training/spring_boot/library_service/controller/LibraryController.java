package com.training.spring_boot.library_service.controller;

import com.training.spring_boot.library_service.dto.BookDto;
import com.training.spring_boot.library_service.service.LibraryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(path = "/book/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> locateBook(@PathVariable String isbn) {
        BookDto book = libraryService.GetBook(isbn);

        return ResponseEntity.ok(book);
    }
}
