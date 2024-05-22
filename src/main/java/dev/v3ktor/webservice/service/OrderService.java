package dev.v3ktor.webservice.service;

import dev.v3ktor.webservice.model.entity.Order;
import dev.v3ktor.webservice.model.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    //ATRIBUTOS
    @Autowired
    private OrderRepository orderRepository;

    //MÉTODOS
    public List<Order> getAll()
    {
        return orderRepository.findAll();
    }

    public Order getById(Long id)
    {
        Order order = orderRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException());

        return order;
    }

}
