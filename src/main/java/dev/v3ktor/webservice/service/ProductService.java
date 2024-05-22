package dev.v3ktor.webservice.service;

import dev.v3ktor.webservice.model.entity.Product;
import dev.v3ktor.webservice.model.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //ATRIBUTOS
    @Autowired
    private ProductRepository productRepository;

    //MÉTODOS
    public Product getById(Long id)
    {
        Product p = productRepository.findById(id)
                .orElseThrow( EntityExistsException::new );
        return p;
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

}
