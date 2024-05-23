package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.User;
import dev.v3ktor.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping()
    public ResponseEntity<User> insert( @RequestBody User obj ) throws URISyntaxException {
       User e = service.insert(obj);
       URI uri = new URI( String.format("/api/users/%d", e.getId()) );
       return ResponseEntity.created(uri).body(e);
    }

}
