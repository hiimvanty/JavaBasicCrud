package com.devcamp.api.task_66_crud_province.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "district")
public class CDistrict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefix")
    private String prefix;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    @JsonBackReference
    private CProvince province;

    @OneToMany(targetEntity = CWard.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    @JsonManagedReference
    private Set<CWard> wards;


    public CDistrict() {
        super();
    }

    public CDistrict(int id, String name, String prefix) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
    }

    public CDistrict(int id, String name, String prefix, CProvince province, Set<CWard> wards) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.province = province;
        this.wards = wards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Set<CWard> getWards() {
        return wards;
    }

    public void setWards(Set<CWard> wards) {
        this.wards = wards;
    }

    public CProvince getProvince() {
        return province;
    }

    public void setProvince(CProvince province) {
        this.province = province;
    }

}
