package com.example.bankSystem.service;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.dto.CustomerMapperImpl;
import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.CustomerMapper;
import com.example.bankSystem.util.Mapper;
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
        return customer;
    }
}
