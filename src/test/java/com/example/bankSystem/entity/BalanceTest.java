package com.example.bankSystem.entity;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {
    @Test
    void getId_correctId() {
        Balance balance = new Balance();
        balance.setId(1);
        var result = balance.getId();
        assertEquals(1, result);
    }

    @Test
    void getId_correctAccountId() {
        Balance balance = new Balance();
        balance.setAccount_id(1);
        var result = balance.getAccount_id();
        assertEquals(1, result);
    }

    @Test
    void getId_correctCurrency() {
        Balance balance = new Balance();
        balance.setCurrency(Currencies.EUR);
        var result = balance.getCurrency();
        assertEquals(Currencies.EUR, result);
    }

    @Test
    void getId_correctAmount() {
        Balance balance = new Balance();
        balance.setAmount(BigDecimal.ZERO);
        var result = balance.getAmount();
        assertEquals(BigDecimal.ZERO, result);
    }
}
