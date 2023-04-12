package com.example.bankSystem.util;

import com.example.bankSystem.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO customers (country, name) VALUES (#{country}, #{name})")
    void insert(Customer customer);
}
