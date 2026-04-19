package com.example.service;

import com.example.controller.PrdouctController;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

  //  private final OllamaService ollamaService;
    @Autowired
    private GroqService groqService;

    public String recommendProducts(String query)
    {
        List<Product> products=productRepository.findAll();
        return groqService.getRecommendations(query,products);
    }
    //create
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    //read
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    //findByid
    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }

    //update
    public Product updatePrdouct(Product product,Long id){
       Product existing=getById(id);
       existing.setPrice(product.getPrice());
       existing.setName(product.getName());
       return productRepository.save(existing);
    }

    //Delete
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    //getByName
    public Product getByName(String name){
        return productRepository.findByName(name);
    }

    public String updateProductPrice(Long id, Double price){
        productRepository.updateProductPrice(id,price);
        return null;
    }


}
