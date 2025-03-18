package org.example.productspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);
		ProductService service = context.getBean(ProductService.class);


		System.out.println(" Fetching all the products : ");


		List<Product> allProducts = service.getallproducts();
		for (Product product : allProducts) {
			System.out.println(product);


		}

		System.out.println("Fetching product that has iPad Mini as name of the product in the product list : ");
		Product p = service.getproduct("iPad Mini");
		System.out.println(p);

		System.out.println("Fetching the products from the database that are out of warranty :");
		List<Product> OutWarranty = service.outWarranty(2025);
		for (Product thr : OutWarranty) {
			System.out.println(thr);
		}

		System.out.println("Fetching the products that contains BOOK keyword in name, place  and type :");

		List<Product> containsText = service.containText("BOOK");
		for (Product con : containsText) {
			System.out.println(con);
		}

	}
}
