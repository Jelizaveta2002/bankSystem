package com.example.bankSystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.example.bankSystem.entity.*;
import com.example.bankSystem.service.TransactionService;
import com.example.bankSystem.util.AccountMapper;
import com.example.bankSystem.util.BalanceMapper;
import com.example.bankSystem.util.TransactionMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionServiceTests {

    @Mock
    private AccountMapper accountMapper;

    @Mock
    private BalanceMapper balanceMapper;

    @Mock
    private TransactionMapper transactionMapper;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testCreateTransaction() throws IllegalAccessException {
        Integer accountId = 19;
        BigDecimal amount = new BigDecimal("100");
        Currencies currencies = Currencies.USD;
        Direction direction = Direction.IN;
        String description = "Test transaction";
        Balance balance = new Balance();
        balance.setId(2);
        balance.setAmount(new BigDecimal("500"));
        List<Balance> balances = Collections.singletonList(balance);

        when(accountMapper.getAccountById(accountId)).thenReturn(new Account());
        when(balanceMapper.getBalancesByAccIdAndCurrency(accountId, currencies)).thenReturn(balances);

        Transaction transaction = transactionService.createTransaction(accountId, amount, currencies, direction, description);

        assertNotNull(transaction);
        assertEquals(accountId, transaction.getAccount_id());
        assertEquals(amount, transaction.getAmount());
        assertEquals(currencies, transaction.getCurrency());
        assertEquals(direction, transaction.getDirection());

        assertEquals(description, transaction.getDescription());
        assertEquals(balance, transaction.getBalance());

        assertEquals(balance.getId(), transaction.getBalance_id());

        verify(transactionMapper).insert(transaction);
    }
}
