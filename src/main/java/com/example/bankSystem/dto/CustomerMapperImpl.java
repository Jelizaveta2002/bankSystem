package com.example.bankSystem.dto;

import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements Mapper {
    @Override
    public CustomerDTO toDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setCountry(customer.getCountry());
        dto.setCurrencies(customer.getCurrencies());
        return dto;
    }

    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setCountry(customerDTO.getCountry());
        customer.setCurrencies(customerDTO.getCurrencies());
        return customer;
    }
}
