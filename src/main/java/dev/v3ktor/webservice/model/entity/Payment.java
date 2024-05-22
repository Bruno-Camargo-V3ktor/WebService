package dev.v3ktor.webservice.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity @Table(name = "payments")
public class Payment implements Serializable {

    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    //ASSOCIAÇÕES
    @OneToOne @MapsId
    private Order order;

    //CONSTRUTORES
    public Payment() {}
    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    //GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Instant getMoment() { return moment; }
    public void setMoment(Instant moment) { this.moment = moment; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    //HASHCODE & EQUALS
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }
    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }


}
