package com.accion.demo.webservices.productdemowebservices.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accion.demo.webservices.productdemowebservices.model.Product;
import com.accion.demo.webservices.productdemowebservices.repository.ProductDaoService;


@RestController
public class ProductResource {
	
	@Autowired
	private ProductDaoService service;
	
	@GetMapping("/products")
	public List<Product> retreiveAllProducts() {
		return service.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product retrieveProduct(@PathVariable int id) {
		return service.findOne(id);
	}
	
	@PostMapping("/product/add")
	public ResponseEntity<Object> createProduct (@RequestBody Product product) {
		Product savedProduct = service.save(product);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
