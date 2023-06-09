package com.example.bankSystem.controller;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "addCustomer")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.insert(customerDTO));
    }

}
