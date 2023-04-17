package com.example.bankSystem.service;

import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Direction;
import com.example.bankSystem.entity.Transaction;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import com.example.bankSystem.util.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TransactionService {

    @Autowired
    private BalanceMapper balanceMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private AccountMapper accountMapper;

    public Transaction createTransaction (Integer account_id, BigDecimal amount, Currencies currencies, Direction direction, String description) throws IllegalAccessException {
        if (accountMapper.getAccountById(account_id) == null) {
            throw new IllegalAccessException("Account missing!");
        }
        int diff = amount.compareTo(BigDecimal.ZERO);
        if (diff < 0) {
            throw new IllegalAccessException("Invalid amount !");
        }
        Transaction transaction = new Transaction();
        List<Balance> balances = balanceMapper.getBalancesByAccIdAndCurrency(account_id, currencies);
        if (!balances.isEmpty()) {
            Balance balance = balances.get(0);
            if (direction == Direction.OUT) {
                int difference = balance.getAmount().compareTo(amount);
                if (difference > 0) {
                    balance.setAmount(balance.getAmount().subtract(amount));
                } else {
                    throw new IllegalAccessException("You do not have enough money for this transaction !");
                }
            }
            else if (direction == Direction.IN) {
                balance.setAmount(balance.getAmount().add(amount));
            }
            balanceMapper.updateBalanceAmount(balance.getAmount(), balance.getId());
            transaction.setAccount_id(account_id);
            transaction.setAmount(amount);
            transaction.setCurrency(currencies);
            transaction.setDirection(direction);
            transaction.setDescription(description);
            transaction.setBalance(balance);
            transaction.setBalance_id(balance.getId());
            transactionMapper.insert(transaction);
            return transaction;
        }
        throw new IllegalAccessException("Invalid currency");
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions =  transactionMapper.findAll();
        for (Transaction transaction : transactions) {
            transaction.setBalance(balanceMapper.getBalancesById(transaction.getBalance_id())); //set balance for each entity using balance_id
        }
        return transactions;
    }
}
