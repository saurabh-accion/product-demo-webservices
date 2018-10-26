package com.accion.demo.webservices.productdemowebservices.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accion.demo.webservices.productdemowebservices.model.Product;
import com.accion.demo.webservices.productdemowebservices.repository.ProductRepository;
import com.accion.demo.webservices.productdemowebservices.service.ProductService;

@RestController
public class ProductJPAResource implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/jpa/products")
	public List<Product> retreiveAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/jpa/product/{id}")
	public Optional<Product> retrieveProduct(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/jpa/product/add")
	public ResponseEntity<Object> createProduct (@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
}
