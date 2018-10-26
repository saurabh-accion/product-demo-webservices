package com.accion.demo.webservices.productdemowebservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accion.demo.webservices.productdemowebservices.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
