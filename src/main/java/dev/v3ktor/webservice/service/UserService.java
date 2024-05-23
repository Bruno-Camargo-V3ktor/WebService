package dev.v3ktor.webservice.service;

import dev.v3ktor.webservice.model.entity.User;
import dev.v3ktor.webservice.model.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //ATRIBUTOS
    @Autowired
    private UserRepository userRepository;

    //MÉTODOS
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public User getById(Long id)
    {
        User user = userRepository.findById(id)
                .orElseThrow( EntityNotFoundException::new );

        return user;
    }

    public User insert(User obj)
    {
        return userRepository.save(obj);
    }

    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }

}
