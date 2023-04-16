package com.example.bankSystem.entity;

import com.example.bankSystem.util.BalanceMapper;

import java.math.BigDecimal;

public class Transaction {

    private BalanceMapper balanceMapper;

    private Integer id;
    private Integer account_id;
    private BigDecimal amount;
    private Currencies currency;
    private String description;

    private Balance balance;


    private Integer balance_id;

    private Direction direction;

    public Balance getBalance() {

        return balance;
    }

    public Integer getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(Integer balance_id) {
        this.balance_id = balance_id;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
