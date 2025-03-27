package com.training.spring.rest_client;

import com.training.spring.rest_client.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class RestClient2 {
    public static void main(String[] args) {

        RestClient.Builder builder = RestClient.builder();
        builder.requestInterceptor(new ClientCustomInterceptor());

        BookDTO book = builder.build().get()
                .uri("http://localhost:8070/libraries/book/112233")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BookDTO.class);

        System.out.println(book);
    }
}
