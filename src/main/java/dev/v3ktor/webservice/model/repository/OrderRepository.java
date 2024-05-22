package dev.v3ktor.webservice.model.repository;

import dev.v3ktor.webservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
