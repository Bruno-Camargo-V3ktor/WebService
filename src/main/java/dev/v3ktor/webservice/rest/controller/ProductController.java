package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.Product;
import dev.v3ktor.webservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api/products")
public class ProductController {

    //ATRIBUTOS
    @Autowired
    private ProductService service;

    //ENDPOINTS
    @GetMapping("{id}")
    public ResponseEntity<Product> getById( @PathVariable Long id )
    {
        return ResponseEntity.ok( service.getById(id) );
    }

    public ResponseEntity< List<Product> > getAll()
    {
        return ResponseEntity.ok( service.getAll() );
    }

}
