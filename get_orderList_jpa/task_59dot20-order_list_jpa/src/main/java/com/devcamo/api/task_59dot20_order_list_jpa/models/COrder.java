package com.devcamo.api.task_59dot20_order_list_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class COrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "customer_Id")
    private long customerId;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "pizza_size")
    private String pizzaSize;
    @Column(name = "pizza_type")
    private String pizzaType;
    @Column(name = "voucher_code")
    private String voucherCode;
    @Column(name = "price")
    private long price;
    @Column(name = "paid")
    private long paid;

    public COrder() {
        super();
    }

    public COrder(long id, String orderCode, long customerId, long productId, String pizzaSize, String pizzaType,
            String voucherCode, long price, long paid) {
        super();
        this.id = id;
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.productId = productId;
        this.pizzaSize = pizzaSize;
        this.pizzaType = pizzaType;
        this.voucherCode = voucherCode;
        this.price = price;
        this.paid = paid;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPaid() {
        return paid;
    }

    public void setPaid(long paid) {
        this.paid = paid;
    };

}
