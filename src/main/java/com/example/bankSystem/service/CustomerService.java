package com.example.bankSystem.service;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.dto.CustomerMapperImpl;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerMapperImpl mapper;

    public Object insert(CustomerDTO customerDTO) {
        Customer customer = mapper.toCustomer(customerDTO);
        customerMapper.insert(customer);
        Integer id = customer.getId();
        for (Currencies currency : customer.getCurrency()) {
            customerMapper.insertCurrency(id, currency);
        }
        return customer;
    }

    public Customer findById(Integer id) {
        return customerMapper.getUserById(id);
    }
}
