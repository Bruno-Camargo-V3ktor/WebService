package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.Category;
import dev.v3ktor.webservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api/categories")
public class CategoryController {

    //ATRIBUTOS
    @Autowired
    private CategoryService service;

    //ENDPOINTS
    @GetMapping("{id}")
    public ResponseEntity<Category> getById( @PathVariable("id") Long id )
    {
        return ResponseEntity.ok( service.getById(id) );
    }

    @GetMapping()
    public ResponseEntity< List<Category> > getAll()
    {
        return ResponseEntity.ok( service.getAll() );
    }

}
