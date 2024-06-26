package dev.v3ktor.webservice.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.v3ktor.webservice.model.entity.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity @Table(name = "orders")
public class Order implements Serializable {

    //ATRIBUTOS
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy/mm/dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer status;

    //ASSOCIAÇÕES
    @ManyToOne @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    //CONSTRUTORES
    public Order() {}
    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    //GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Instant getMoment() { return moment; }
    public void setMoment(Instant moment) { this.moment = moment;}

    public OrderStatus getStatus() { return OrderStatus.valueOf(status); }
    public void setStatus(OrderStatus status) { this.status = status.getCode(); }

    public User getClient() { return client; }
    public void setClient(User client) { this.client = client;}

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public Set<OrderItem> getItems() { return items; }

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
    public Double getTotal()
    {
        Double total = 0.0;
        for(OrderItem item: items) { total += item.getSubtotal(); }
        return total;
    }

}
