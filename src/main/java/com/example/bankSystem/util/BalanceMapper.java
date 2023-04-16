package com.example.bankSystem.util;

import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Currencies;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface BalanceMapper {
    @Insert("INSERT INTO balances (account_id, currency, amount) VALUES (#{account_id}, #{currency}, #{amount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Balance balance);

    @Select("SELECT * FROM balances WHERE account_id = #{account_id}")
    List<Balance> getBalancesByAccountId(Integer account_id);

    @Select("SELECT * FROM balances WHERE account_id = #{account_id} AND currency = #{currency}")
    List<Balance> getBalancesByAccIdAndCurrency(@Param("account_id")Integer account_id, @Param("currency") Currencies currency);

    @Select("SELECT * FROM balances WHERE id = #{id}")
    Balance getBalancesById(@Param("id")Integer id);

    @Update("UPDATE balances SET amount = #{newAmount} WHERE id = #{balanceId}")
    void updateBalanceAmount(@Param("newAmount") BigDecimal newAmount, @Param("balanceId") Integer balanceId);
}
