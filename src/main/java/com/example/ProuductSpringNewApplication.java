package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProuductSpringNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProuductSpringNewApplication.class, args);
    }

}