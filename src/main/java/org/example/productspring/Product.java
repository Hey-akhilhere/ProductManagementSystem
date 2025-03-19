package org.example.productspring;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String place;
    private int warranty;


    public Product() {
        this.name = null;  // String fields are defaulted to null
        this.type = null;
        this.place = null;
        this.warranty = 0;  // Integer fields are defaulted to 0
    }

    public Product(String name, String type, String place, int warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }



    }
:wq

