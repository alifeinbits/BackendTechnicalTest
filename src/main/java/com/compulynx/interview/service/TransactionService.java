package com.compulynx.interview.service;

import com.compulynx.interview.model.Account;
import com.compulynx.interview.model.Transaction;
import com.compulynx.interview.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Account account, double amount, String type) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    public List<Transaction> findLast10Transactions(Account account) {
        return transactionRepository.findTop10ByAccountOrderByIdDesc(account);
    }

    public Transaction findByTransactionId(String transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
    }
}
