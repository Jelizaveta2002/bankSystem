package com.example.bankSystem.controller;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(String.valueOf(customerService.insert(customerDTO)));
    }

}
