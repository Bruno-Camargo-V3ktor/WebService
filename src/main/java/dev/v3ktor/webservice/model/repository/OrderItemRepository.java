package dev.v3ktor.webservice.model.repository;

import dev.v3ktor.webservice.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { }