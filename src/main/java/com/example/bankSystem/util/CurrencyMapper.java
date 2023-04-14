package com.example.bankSystem.util;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Currencies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CurrencyMapper {

    @Select("SELECT currency FROM currencies WHERE customer_id = #{customer_id}")
    List<Currencies> getCurrenciesById(Integer customer_id);
}
