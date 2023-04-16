package com.example.bankSystem.service;


import com.example.bankSystem.entity.Account;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BalanceMapper balanceMapper;

    public Object addAccount(Integer id) {

        try{Account account = new Account();
            account.setCustomer_id(id);
            accountMapper.insert(account);
            return null;
        }
        catch (Exception exception){
            return "Account is already exists or customer with this id does not exist!";
        }
    }

    public Account findAccountById(Integer accountId) {
        Account account = accountMapper.getAccountById(accountId);
        account.setListOfBalances(balanceMapper.getBalancesById(accountId));
        return account;
    }
}
