package dev.v3ktor.webservice.rest.controller;

import dev.v3ktor.webservice.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/users")
public class UserController {

    //ENDPOINTS
    @GetMapping()
    public ResponseEntity<User> getAll()
    {
        User u = new User(0L, "Bruno C.", "brunocamargo2280@gmail", "11996489713", "brunobr11");
        return ResponseEntity.ok(u);
    }

}
