package com.example.bankSystem.dto;

import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.MapperDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements MapperDTO {
    @Override
    public CustomerDTO toDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setCountry(customer.getCountry());
        dto.setCurrencies(customer.getCurrency());
        return dto;
    }

    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setCountry(customerDTO.getCountry());
        customer.setCurrency(customerDTO.getCurrencies());
        return customer;
    }
}
