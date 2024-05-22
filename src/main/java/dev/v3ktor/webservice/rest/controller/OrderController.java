package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.Order;
import dev.v3ktor.webservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/orders")
public class OrderController {

    //ATRIBUTOS
    @Autowired
    private OrderService service;

    //ENDPOINTS
    @GetMapping()
    public ResponseEntity< List<Order> > getAll()
    {
        return ResponseEntity.ok( service.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById( @PathVariable("id") Long id )
    {
        return ResponseEntity.ok( service.getById(id) );
    }

}
