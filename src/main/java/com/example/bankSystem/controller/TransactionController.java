package com.example.bankSystem.controller;

import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Direction;
import com.example.bankSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transAction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "addTrans")
    public ResponseEntity<Object> addTransaction(Integer account_id, BigDecimal amount, Currencies currencies, Direction direction, String description) throws IllegalAccessException {
        return ResponseEntity.ok(transactionService.createTransaction(account_id, amount, currencies, direction, description));
    }
}
