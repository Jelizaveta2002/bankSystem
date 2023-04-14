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

    private Integer customer_id;

    @OneToMany
    private List<Balance> listOfBalances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customerId) {
        this.customer_id = customerId;
    }

    public List<Balance> getListOfBalances() {
        return listOfBalances;
    }

    public void setListOfBalances(List<Balance> listOfBalances) {
        this.listOfBalances = listOfBalances;
    }
}

