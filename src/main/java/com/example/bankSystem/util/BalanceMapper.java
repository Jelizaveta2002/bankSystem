package com.example.bankSystem.util;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Balance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BalanceMapper {
    @Insert("INSERT INTO balances (account_id, currency, amount) VALUES (#{account_id}, #{currency}, #{amount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Balance balance);

    @Select("SELECT * FROM balances WHERE account_id = #{account_id}")
    List<Balance> getBalancesById(Integer account_id);
}
