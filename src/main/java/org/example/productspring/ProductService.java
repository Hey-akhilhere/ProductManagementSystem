package org.example.productspring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService{

    @Autowired
    ProductDB db;

    public List<Product> getallproducts(){
        return db.findAll();

    }

    public Product getproduct(String name){

        Product productByName = db.findByName(name);

        if(productByName != null)
        {
            return productByName;
        }
        else {
            System.out.println("No product found with name " + name);
            return null;
        }

    }

    public List<Product> outWarranty(int warranty){
                return db.findProductsOutOfWarranty(warranty);
    }

    public List<Product> containText(String text){
        return db.findByTextContaining(text);
    }


}