package com.example.bankSystem.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer customerId;

    @OneToMany
    private List<Balance> listOfBalances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Balance> getListOfBalances() {
        return listOfBalances;
    }

    public void setListOfBalances(List<Balance> listOfBalances) {
        this.listOfBalances = listOfBalances;
    }
}

