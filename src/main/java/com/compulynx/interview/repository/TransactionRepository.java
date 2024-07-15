package com.compulynx.interview.repository;


import com.compulynx.interview.model.Account;
import com.compulynx.interview.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop10ByAccountOrderByIdDesc(Account account);
    Transaction findByTransactionId(String transactionId);
}
