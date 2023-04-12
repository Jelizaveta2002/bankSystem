package com.example.bankSystem.util;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.entity.Customer;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    CustomerDTO toDto(Customer customer);

    Customer toCustomer(CustomerDTO customerDTO);

}
