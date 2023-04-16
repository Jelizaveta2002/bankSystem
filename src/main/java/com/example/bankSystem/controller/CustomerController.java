package com.example.bankSystem.controller;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.service.AccountService;
import com.example.bankSystem.service.BalanceService;
import com.example.bankSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BalanceService balanceService;

    @PostMapping(value = "addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(String.valueOf(customerService.insert(customerDTO)));
    }

    @GetMapping(value = "addAccount")
    public ResponseEntity<String> addAccount(Integer id) {
        return ResponseEntity.ok(String.valueOf(accountService.addAccount(id)));
    }

    @GetMapping(value = "addBalance")
    public ResponseEntity<String> addBalance(Integer account_id, Currencies currency, BigDecimal amount) {
        return ResponseEntity.ok(String.valueOf(balanceService.addBalance(account_id, currency, amount)));
    }

    @GetMapping(value = "getAccount")
    public ResponseEntity<Account> getAccount(Integer account_id) {
        return ResponseEntity.ok(accountService.findAccountById(account_id));
    }

}
