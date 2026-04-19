package com.example.Config;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductRepository repo) {
        return args -> {

            // Prevent duplicate insertion
            if (repo.count() > 0) {
                System.out.println("⚡ Data already loaded");
                return;
            }
            if (repo.count() == 0) {
                System.out.println("🚀 Loading dummy product data...");
                repo.saveAll(List.of(
                        new Product(10L, "Gaming Laptop", 75000.0),
                        new Product(20L, "Budget Phone", 15000.0),
                        new Product(30L, "Smart TV", 40000.0),
                        new Product(40L, "Wireless Earbuds", 3000.0),
                        new Product(50L, "Smart Watch", 5000.0),
                        new Product(60L, "Tablet", 20000.0),
                        new Product(70L, "Bluetooth Speaker", 2500.0),
                        new Product(80L, "DSLR Camera", 55000.0),
                        new Product(90L, "Gaming Mouse", 1200.0),
                        new Product(100L, "Mechanical Keyboard", 3500.0)
                ));

                IO.println("✅ Dummy data loaded successfully!");
            }else{
                IO.println("⚡ Data already exists in PRODUCT table.");
            }
        };
    }
}