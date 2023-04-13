package com.example.bankSystem.util;

import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Customer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO customers (country, name) VALUES (#{country}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Customer customer);

    @Insert("INSERT INTO currencies (customer_id, currency) VALUES (#{customer_id}, #{currency})")
    void insertCurrency(@Param("customer_id") Integer customer_id, @Param("currency") Currencies currency);
}
