package com.example.bankSystem.util;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Balance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface BalanceMapper {
    @Insert("INSERT INTO balances (account_id, currency, amount) VALUES (#{account_id}, #{currency}, #{amount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Balance balance);
}
