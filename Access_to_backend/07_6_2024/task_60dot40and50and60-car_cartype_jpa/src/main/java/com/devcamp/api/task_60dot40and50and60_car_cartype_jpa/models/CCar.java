package com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class CCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "car_code", unique = true)
    private String carCode;

    @Column(name = "car_name")
    private String carName;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CCarType> types;

    public CCar() {

    }

    public CCar(String carCode, String carName) {
        this.carCode = carCode;
        this.carName = carName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Set<CCarType> getTypes() {
        return types;
    }

    public void setTypes(Set<CCarType> types) {
        this.types = types;
    };

}
