package com.devcamp.api.task_65dot30_crud_user_order.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "pizza_order")
public class COrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_code", nullable = false, updatable = false)
    private String orderCode;

    @Column(name = "pizza_size", nullable = false, updatable = true)
    private String pizzaSize;

    @Column(name = "pizza_type", nullable = false, updatable = true)
    private String pizzaType;

    @Column(name = "voucher_code", nullable = true, updatable = true)
    private String voucherCode;

    @Column(name = "price", nullable = true, updatable = true)
    private long price;

    @Column(name = "paid", nullable = true, updatable = true)
    private long paid;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at", nullable = true, updatable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at", nullable = true, updatable = true)
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private CUser cUser;

    public COrder() {
        super();
    }

    public COrder(long id, String orderCode, String pizzaSize, String pizzaType, String voucherCode, long price,
            long paid) {
        this.id = id;
        this.orderCode = orderCode;
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
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return update_at;
    }

    public void setUpdated_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public CUser getcUser() {
        return cUser;
    }

    public void setcUser(CUser cUser) {
        this.cUser = cUser;
    }

}
