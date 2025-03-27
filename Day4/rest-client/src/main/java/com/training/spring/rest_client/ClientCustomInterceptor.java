package com.training.spring.rest_client;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class ClientCustomInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String encodedCredentials = new String(Base64.getEncoder().encode("Gowthaman:password".getBytes()));
        request.getHeaders().add("Authorization", "Basic " + encodedCredentials);
        return execution.execute(request, body);
    }
}
