package com.example.bankSystem.controller;

import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Direction;
import com.example.bankSystem.entity.Transaction;
import com.example.bankSystem.mqrabbit.RabbitConfig;
import com.example.bankSystem.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transAction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "addTrans")
    public ResponseEntity<Object> addTransaction(Integer account_id, BigDecimal amount, Currencies currencies, Direction direction, String description) throws IllegalAccessException, JsonProcessingException {
        Transaction transaction = transactionService.createTransaction(account_id, amount, currencies, direction, description);
        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(transaction);
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, message);
        return ResponseEntity.ok(transaction);
    }
}
