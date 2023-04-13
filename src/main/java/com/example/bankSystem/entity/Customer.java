package com.example.bankSystem.entity;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    private String country;

    @ElementCollection
    private List<Currencies> currency;

    public List<Currencies> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currencies> currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
