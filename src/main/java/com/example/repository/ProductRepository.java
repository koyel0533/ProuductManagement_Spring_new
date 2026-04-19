package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByName(String name);

   @Procedure(procedureName = "update_product_price")
    void updateProductPrice(@Param("P_ID") Long id,  @Param("PRICE") Double price);
}
