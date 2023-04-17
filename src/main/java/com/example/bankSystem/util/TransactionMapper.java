package com.example.bankSystem.util;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Insert("INSERT INTO transactions (account_id, currency, amount, description, direction, balance_id) VALUES (#{account_id}, #{currency}, #{amount}, #{description}, #{direction}, #{balance_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Transaction transaction);

    @Select("SELECT * FROM transactions")
    List<Transaction> findAll();
}
