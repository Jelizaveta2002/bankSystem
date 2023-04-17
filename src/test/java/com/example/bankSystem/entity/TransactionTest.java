package com.example.bankSystem.entity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    void getId_correctId() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        var result = transaction.getId();
        assertEquals(1, result);
    }

    @Test
    void getId_correctAccountId() {
        Transaction transaction = new Transaction();
        transaction.setAccount_id(1);
        var result = transaction.getAccount_id();
        assertEquals(1, result);
    }

    @Test
    void getId_correctDescription() {
        Transaction transaction = new Transaction();
        transaction.setDescription("Add money");
        var result = transaction.getDescription();
        assertEquals("Add money", result);
    }

    @Test
    void getId_correctCurrency() {
        Transaction transaction = new Transaction();
        transaction.setCurrency(Currencies.EUR);
        var result = transaction.getCurrency();
        assertEquals(Currencies.EUR, result);
    }

    @Test
    void getId_correctBalanceId() {
        Transaction transaction = new Transaction();
        transaction.setBalance_id(1);
        var result = transaction.getBalance_id();
        assertEquals(1, result);
    }

    @Test
    void getId_correctDirection() {
        Transaction transaction = new Transaction();
        transaction.setDirection(Direction.IN);
        var result = transaction.getDirection();
        assertEquals(Direction.IN, result);
    }
}
