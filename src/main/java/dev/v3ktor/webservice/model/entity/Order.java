package dev.v3ktor.webservice.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity @Table(name = "orders")
public class Order implements Serializable {

    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    //ASSOCIAÇÕES
    @ManyToOne @JoinColumn(name = "client_id")
    private User client;

    //CONSTRUTORES
    public Order() {}
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    //GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Instant getMoment() { return moment; }
    public void setMoment(Instant moment) { this.moment = moment;}

    public User getClient() { return client; }
    public void setClient(User client) { this.client = client;}

    //HashCode & Equals
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    //MÉTODOS
    //...

}
