package com.compulynx.interview.service;

import com.compulynx.interview.model.Account;
import com.compulynx.interview.model.Customer;
import com.compulynx.interview.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Customer customer) {
        Account account = new Account();
        account.setAccountId(customer.getCustomerId());
        account.setBalance(0.0);
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    public Account findByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public double getBalance(Account account) {
        return account.getBalance();
    }
}
