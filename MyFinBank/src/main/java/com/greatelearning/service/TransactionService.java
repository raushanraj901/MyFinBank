package com.greatelearning.service;


import com.greatelearning.entity.Customer;
import com.greatelearning.entity.Transaction;
import com.greatelearning.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Customer customer, Double amount, String type) {
        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setTransactionId(UUID.randomUUID().toString());

        return transactionRepository.save(transaction);
    }
}
