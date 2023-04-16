package com.example.bankSystem.util;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Insert("INSERT INTO accounts (customer_id) VALUES (#{customer_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Account account);

    @Select("SELECT * FROM accounts WHERE id = #{id}")
    Account getAccountById(Integer id);

}

