package com.devcamp.api.task_60dot70and80_customer_order_jpa.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "corder")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class COrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_code", unique = true)
    private String orderCode;
    @Column(name = "pizza_type")
    private String pizzaType;
    @Column(name = "pizza_size")
    private String pizzaSize;
    @Column(name = "voucher_code")
    private String voucherCode;
    @Column(name = "paid")
    private long paid;
    @Column(name = "price")
    private long price;

    @OneToMany(mappedBy = "corder", cascade = CascadeType.ALL)
    private Set<CProduct> products;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private CCustomer customer;

    public COrder() {
        super();
    }

    public COrder(String orderCode, String pizzaType, String pizzaSize, String voucherCode, long paid, long price) {
        super();
        this.orderCode = orderCode;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        this.voucherCode = voucherCode;
        this.paid = paid;
        this.price = price;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public long getPaid() {
        return paid;
    }

    public void setPaid(long paid) {
        this.paid = paid;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public CCustomer getCustomers() {
        return customer;
    }

    public void setCustomer(CCustomer customer) {
        this.customer = customer;
    }

    public Set<CProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<CProduct> products) {
        this.products = products;
    }

}
