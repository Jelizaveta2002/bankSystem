package com.example.bankSystem.service;


import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import com.example.bankSystem.util.CurrencyMapper;
import com.example.bankSystem.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private BalanceMapper balanceMapper;

    @Autowired
    private CurrencyMapper currencyMapper;

    public Account addAccount(Integer id) throws IllegalArgumentException{
        if (customerMapper.getUserById(id) == null) {
            throw new IllegalArgumentException("Account is already exists or customer with this id does not exist!");
        }
        Account account = new Account();
        account.setCustomer_id(id);
        accountMapper.insert(account);
        List<Currencies> currenciesList = currencyMapper.getCurrenciesById(id);
        for(Currencies currency: currenciesList) {
            balanceService.addBalance(account.getId(), currency, BigDecimal.ZERO);
        }
        List<Balance> list = balanceMapper.getBalancesByAccountId(account.getId());
        account.setListOfBalances(list);
        return account;
    }

    public Account findAccountById(Integer accountId) {
        Account account = accountMapper.getAccountById(accountId);
        account.setListOfBalances(balanceMapper.getBalancesByAccountId(accountId));
        return account;
    }
}
