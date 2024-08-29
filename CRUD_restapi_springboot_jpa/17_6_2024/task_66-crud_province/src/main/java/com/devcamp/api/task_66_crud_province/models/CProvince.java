package com.devcamp.api.task_66_crud_province.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "province")
public class CProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = CDistrict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id")
    @JsonManagedReference
    private Set<CDistrict> districts;

    public CProvince() {
        super();
    }

    public CProvince(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public CProvince(int id, String code, String name, Set<CDistrict> districts) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.districts = districts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CDistrict> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<CDistrict> districts) {
        this.districts = districts;
    }

}
