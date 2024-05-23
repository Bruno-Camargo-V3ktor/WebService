package dev.v3ktor.webservice.service;

import dev.v3ktor.webservice.model.entity.User;
import dev.v3ktor.webservice.model.repository.UserRepository;
import dev.v3ktor.webservice.rest.exception.DatabaseException;
import dev.v3ktor.webservice.rest.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        User user = userRepository.findById(id).orElseThrow( () -> new EntityNotFoundException(id) );
        return user;
    }

    public User insert(User obj)
    {
        return userRepository.save(obj);
    }

    public void deleteById(Long id)
    {
        User entity = userRepository.findById(id).orElseThrow( () -> new EntityNotFoundException(id) );

        try
        { userRepository.delete(entity); }
        catch (DataIntegrityViolationException ex)
        { throw new DatabaseException( ex.getMessage() ); }
    }

    public User updateById(Long id, User obj)
    {
        User entity = userRepository.findById(id).orElseThrow( () -> new EntityNotFoundException(id) );
        entity.setName( obj.getName() );
        entity.setEmail( obj.getEmail() );
        entity.setPhone( obj.getPhone() );

        return userRepository.save( entity );
    }

}
