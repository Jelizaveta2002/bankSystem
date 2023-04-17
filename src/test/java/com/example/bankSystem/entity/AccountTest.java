package com.example.bankSystem.entity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void getId_correctId() {
        Account account = new Account();
        account.setId(1);
        var result = account.getId();
        assertEquals(1, result);
    }

    @Test
    void getId_correctCustomerId() {
        Account account = new Account();
        account.setCustomer_id(1);
        var result = account.getCustomer_id();
        assertEquals(1, result);
    }
}
