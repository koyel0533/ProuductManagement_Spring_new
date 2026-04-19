package com.example.service;

import com.example.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GroqService {

    @Value("${spring.ai.openai.api-key}")
    private String API_KEY;

    public String getRecommendations(String query, List<Product> products) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "You are a product recommendation AI.\n\n" +
                "USER QUERY:\n" + query + "\n\n" +
                "AVAILABLE PRODUCTS:\n" + products.toString();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

       // ✅ FIXED PART
        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        List<Map<String, Object>> messages = new ArrayList<>();
        messages.add(message);

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama-3.1-8b-instant");
        request.put("messages", messages);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        return restTemplate.postForObject(
                "https://api.groq.com/openai/v1/chat/completions",
                entity,
                String.class
        );



    }

}
