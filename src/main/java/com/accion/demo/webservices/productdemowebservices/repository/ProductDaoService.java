package com.accion.demo.webservices.productdemowebservices.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.accion.demo.webservices.productdemowebservices.model.Product;

@Component
public class ProductDaoService {
private static List<Product> Products = new ArrayList<>();
	
	private static int ProductsCount = 3;
	
	static {
		Products.add(new Product(1, "Redmi 6", 8000,"New Launched Phone with 32 GB internal Space"));
		Products.add(new Product(2, "Reebok Running Shoes", 2500, "New Launched Running Shoes"));
		Products.add(new Product(3, "Macbook Pro", 50000, "Macbook Pro"));
	}
	
	public List<Product> findAll() {
		return Products;
	}
	
	public Product save(Product Product) {
		if(Product.getId()== null) {
			Product.setId(++ProductsCount);
		}
		Products.add(Product);
		return Product;
	}
	
	public Product findOne(int id) {
		for(Product Product:Products) {
			if(Product.getId()== null) {
				return Product;
			}
			
		}
		return null;
	}
}
