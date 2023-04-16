package com.example.bankSystem.controller;

import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping(value = "addBalance")
    public ResponseEntity<String> addBalance(Integer account_id, Currencies currency, BigDecimal amount) {
        return ResponseEntity.ok(String.valueOf(balanceService.addBalance(account_id, currency, amount)));
    }
}
