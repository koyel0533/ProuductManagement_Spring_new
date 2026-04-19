package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class PrdouctController {
    private final ProductService  productService;


    @PostMapping
    public Product addProduct(@RequestBody  Product product){
       return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }
    @GetMapping("{id}")
    public Product getById( @PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("{name}")
    public Product getByName(@PathVariable String name){
        return productService.getByName(name);
    }

    @PutMapping("{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updatePrdouct(product,id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        productService.delete(id);
    }

    @PutMapping("update-price/{id}")
    public String updatePrice(@PathVariable Long id, @RequestParam Double price){
        return productService.updateProductPrice(id,price);
    }

    @GetMapping("/reco")
    public String recommend(@RequestParam String query)
    {
        return productService.recommendProducts(query);
    }

}
