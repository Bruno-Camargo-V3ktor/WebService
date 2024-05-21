package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.User;
import dev.v3ktor.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    //ARIBUTOS
    @Autowired
    private UserService service;

    //ENDPOINTS
    @GetMapping()
    public ResponseEntity< List<User> > getAll()
    {
        return ResponseEntity.ok( service.getAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById( @PathVariable("id") Long id )
    {
        return ResponseEntity.ok( service.getById(id) );
    }

}
