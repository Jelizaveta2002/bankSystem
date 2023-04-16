package com.example.bankSystem.service;

import com.example.bankSystem.entity.Balance;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Direction;
import com.example.bankSystem.entity.Transaction;
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

    public Transaction createTransaction (Integer account_id, BigDecimal amount, Currencies currencies, Direction direction, String description) throws IllegalAccessException {

        Transaction transaction = new Transaction();
        List<Balance> balances = balanceMapper.getBalancesByAccIdAndCurrency(account_id, currencies);
        if (!balances.isEmpty()) {
            Balance balance = balances.get(0);
            if (direction == Direction.OUT) {
                balance.setAmount(balance.getAmount().subtract(amount));
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
        throw new IllegalAccessException("Transaction can not be created !");
    }
}
