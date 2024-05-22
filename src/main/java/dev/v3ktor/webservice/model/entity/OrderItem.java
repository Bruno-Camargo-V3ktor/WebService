package dev.v3ktor.webservice.model.entity;

import dev.v3ktor.webservice.model.entity.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity @Table(name = "orderitems")
public class OrderItem implements Serializable {

    //ATRIBUTOS
    private Integer quantity;
    private Double price;

    @EmbeddedId
    private OrderItemPK id;

    //CONSTRUTORES
    public OrderItem() {}
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    //GETTERS & SETTERS
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Order getOrder() { return id.getOrder(); }
    public void setOrder(Order order) { id.setOrder(order); }

    public Product getProduct() { return id.getProduct(); }
    public void setProduct(Product product) { id.setProduct(product); }

    //HASHCODE & EQUALS
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }
    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }


}
