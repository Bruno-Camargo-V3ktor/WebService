package dev.v3ktor.webservice.model.repository;

import dev.v3ktor.webservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }