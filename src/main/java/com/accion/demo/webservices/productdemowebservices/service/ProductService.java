package com.accion.demo.webservices.productdemowebservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.accion.demo.webservices.productdemowebservices.model.Product;

public interface ProductService {
	
	@PreAuthorize ("hasAnyRole('ADMIN') OR hasAnyRole('USER')")
	List<Product> retreiveAllProducts();

	@PreAuthorize("hasAnyRole('ADMIN')")
	Optional<Product> retrieveProduct(int id);
	
	@PreAuthorize("hasRole('ADMIN')")
	void deleteProduct(int id);
}
