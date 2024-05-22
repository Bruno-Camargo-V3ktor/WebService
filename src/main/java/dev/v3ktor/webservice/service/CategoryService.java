package dev.v3ktor.webservice.service;

import dev.v3ktor.webservice.model.entity.Category;
import dev.v3ktor.webservice.model.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    //ATRIBUTOS
    @Autowired
    private CategoryRepository categoryRepository;

    //MÉTODOS
    public Category getById(Long id)
    {
        Category c = categoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return c;
    }

    public List<Category> getAll()
    {
        return categoryRepository.findAll();
    }

}
