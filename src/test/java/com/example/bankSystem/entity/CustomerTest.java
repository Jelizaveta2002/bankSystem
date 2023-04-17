package com.example.bankSystem.entity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void getId_correctId() {
        Customer customer = new Customer();
        customer.setId(1);
        var result = customer.getId();
        assertEquals(1, result);
    }

    @Test
    void getId_correctName() {
        Customer customer = new Customer();
        customer.setName("Liza");
        var result = customer.getName();
        assertEquals("Liza", result);
    }

    @Test
    void getId_correctCountry() {
        Customer customer = new Customer();
        customer.setCountry("Estonia");
        var result = customer.getCountry();
        assertEquals("Estonia", result);
    }
}
