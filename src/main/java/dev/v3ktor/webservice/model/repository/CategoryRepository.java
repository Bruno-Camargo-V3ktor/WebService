package dev.v3ktor.webservice.model.repository;

import dev.v3ktor.webservice.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }
