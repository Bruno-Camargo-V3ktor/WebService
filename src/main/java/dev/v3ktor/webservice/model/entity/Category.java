package dev.v3ktor.webservice.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity @Table(name = "categories")
public class Category implements Serializable {

    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //CONSTRUTORES
    public Category() {}
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //HASHCODE & EQUALS
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }
    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    //MÉTODOS
    //...

}
