package com.example.bankSystem.service;

import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import com.example.bankSystem.util.CurrencyMapper;
import com.example.bankSystem.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CurrencyMapper currencyMapper;

    public Object addBalance(Integer account_id, Currencies currency, BigDecimal amount) {
        try {
            Account account = accountMapper.getAccountById(account_id);
            Customer customer = customerMapper.getUserById(account.getCustomer_id());
            List<Currencies> currencies =  currencyMapper.getCurrenciesById(customer.getId());
            List<Balance> balances = balanceMapper.getBalancesByAccIdAndCurrency(account_id, currency); //Account can not create 2 balances with the same currency
            if (currencies.contains(currency) && balances.isEmpty()) {
                Balance balance = new Balance();
                balance.setAccount_id(account_id);
                balance.setCurrency(currency);
                balance.setAmount(amount);
                balanceMapper.insert(balance);
                return "Balance created !";
            }
            return "Account does not support this currency! !";
        }
        catch (Exception exception){
            return "Error with creating balance !";
        }

}}
