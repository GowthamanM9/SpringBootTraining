package com.training.spring_boot.rest_client;

import com.training.spring_boot.rest_client.dto.BookDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient1 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/book";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

        RestClient.Builder builder = RestClient.builder();
        List<BookDto> bookResponse = builder.build().get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<List<BookDto>>() {
                });

        for (BookDto book : bookResponse) {
            System.out.println(book);
        }
    }
}
