package com.training.spring.rest_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {

	private String isbn;
	private String name;
	private String author;
	private String genre;
}
