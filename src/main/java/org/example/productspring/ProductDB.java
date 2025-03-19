package org.example.productspring;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

    Product save(Product product);


    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.warranty < :Year")
    List<Product> findProductsOutOfWarranty(@Param("Year") int year);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(p.type) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(p.place) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Product> findByTextContaining(@Param("text") String text);
}

