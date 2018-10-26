package com.accion.demo.webservices.productdemowebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accion.demo.webservices.productdemowebservices.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
