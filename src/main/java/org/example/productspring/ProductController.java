package org.example.productspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/Products")
    public List<Product> getAllProducts(){

        return productService.getallproducts();
    }

    @GetMapping("getProduct/{name}")
    public Product getProduct(@PathVariable String name){
        return productService.getproduct(name);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }


}
