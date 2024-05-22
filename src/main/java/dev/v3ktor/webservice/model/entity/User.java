package dev.v3ktor.webservice.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "users")
public class User implements Serializable {

    //Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //ASSOCIAÇÕES
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    //Construtores
    public User() {}
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    //Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Order> getOrders() { return orders; }

    //Hashcode & Equals
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    //Métodos
    //...

}
