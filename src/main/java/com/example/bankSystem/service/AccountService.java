package com.example.bankSystem.service;


import com.example.bankSystem.entity.Account;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import com.example.bankSystem.util.CurrencyMapper;
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
    private BalanceMapper balanceMapper;

    @Autowired
    private CurrencyMapper currencyMapper;

    public Object addAccount(Integer id) {

        try{Account account = new Account();
            account.setCustomer_id(id);
            accountMapper.insert(account);
            List<Currencies> currenciesList = currencyMapper.getCurrenciesById(id);
            for(Currencies currency: currenciesList) {
                balanceService.addBalance(account.getId(), currency, BigDecimal.ZERO);
            }
            return null;
        }
        catch (Exception exception){
            return "Account is already exists or customer with this id does not exist!";
        }
    }

    public Account findAccountById(Integer accountId) {
        Account account = accountMapper.getAccountById(accountId);
        account.setListOfBalances(balanceMapper.getBalancesByAccountId(accountId));
        return account;
    }
}
