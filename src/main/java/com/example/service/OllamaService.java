package com.example.service;

import com.example.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OllamaService {/*

    private final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String getRecommendations(String query, List<Product> products) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "You are a product recommendation AI.\n\n" +
                "USER QUERY:\n" + query + "\n\n" +
                "AVAILABLE PRODUCTS:\n" + products.toString();

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama3");
        request.put("prompt", prompt);
        request.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        return restTemplate.postForObject(
                "http://localhost:11434/api/generate",
                entity,
                String.class);
    }*/
}