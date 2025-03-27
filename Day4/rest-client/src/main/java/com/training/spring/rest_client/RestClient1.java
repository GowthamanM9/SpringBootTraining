package com.training.spring.rest_client;

import com.training.spring.rest_client.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Base64;

public class RestClient1 {
    public static void main(String[] args) {

        String encodedCredentials = new String(Base64.getEncoder().encode("Gowthaman:password".getBytes()));

        RestClient restClient = RestClient.create();

        BookDTO book = restClient.get()
                .uri("http://localhost:8070/libraries/book/112233")
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic " + encodedCredentials)
                .retrieve()
                .body(BookDTO.class);

        System.out.println(book);

    }
}
