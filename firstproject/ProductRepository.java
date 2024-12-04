package com.example.firstproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product,Long>{
	Optional<product> findById(Long id);
}