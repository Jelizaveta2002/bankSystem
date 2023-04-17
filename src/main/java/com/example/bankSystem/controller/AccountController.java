package com.example.bankSystem.controller;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "addAccount")
    public ResponseEntity<Account> addAccount(Integer id) {
        return ResponseEntity.ok(accountService.addAccount(id));
    }

    @GetMapping(value = "getAccount")
    public ResponseEntity<Account> getAccount(Integer account_id) {
        return ResponseEntity.ok(accountService.findAccountById(account_id));
    }
}
