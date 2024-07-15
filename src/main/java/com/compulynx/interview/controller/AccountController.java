package com.compulynx.interview.controller;


import com.compulynx.interview.model.Account;
import com.compulynx.interview.model.Customer;
import com.compulynx.interview.request.TransactionRequest;
import com.compulynx.interview.service.AccountService;
import com.compulynx.interview.service.CustomerService;
import com.compulynx.interview.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final CustomerService customerService;

    private final AccountService accountService;

    private final TransactionService transactionService;


    public AccountController(CustomerService customerService, AccountService accountService, TransactionService transactionService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }



    @GetMapping("/balance")
    public ResponseEntity<?> getCustomerBalance(@RequestParam String customerId) {
        Customer customer = customerService.findByCustomerId(customerId);
        Account account = accountService.findByAccountId(customer.getCustomerId());
        return ResponseEntity.ok(account);
    }

    @GetMapping("/mini-statement")
    public ResponseEntity<?> getCustomerMiniStatement(@RequestParam String customerId) {
        Customer customer = customerService.findByCustomerId(customerId);
        Account account = accountService.findByAccountId(customer.getCustomerId());
        return ResponseEntity.ok(transactionService.findLast10Transactions(account));
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest transactionRequest) {
        Account account = accountService.findByAccountId(transactionRequest.getAccountId());
        account.setBalance(account.getBalance() + transactionRequest.getAmount());
        accountService.save(account);
        transactionService.createTransaction(account, transactionRequest.getAmount(), "DEPOSIT");
        return ResponseEntity.ok(account.getBalance());
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody TransactionRequest transactionRequest) {
        Account account = accountService.findByAccountId(transactionRequest.getAccountId());
        account.setBalance(account.getBalance() - transactionRequest.getAmount());
        accountService.save(account);
        transactionService.createTransaction(account, transactionRequest.getAmount(), "WITHDRAWAL");
        return ResponseEntity.ok(account.getBalance());
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransactionRequest transactionRequest, @RequestParam String targetAccountId) {
        Account sourceAccount = accountService.findByAccountId(transactionRequest.getAccountId());
        Account targetAccount = accountService.findByAccountId(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - transactionRequest.getAmount());
        targetAccount.setBalance(targetAccount.getBalance() + transactionRequest.getAmount());
        accountService.save(sourceAccount);
        accountService.save(targetAccount);
        transactionService.createTransaction(sourceAccount, transactionRequest.getAmount(), "TRANSFER");
        transactionService.createTransaction(targetAccount, transactionRequest.getAmount(), "TRANSFER");
        return ResponseEntity.ok(sourceAccount.getBalance());
    }

    @GetMapping("/transaction")
    public ResponseEntity<?> getTransactionDetails(@RequestParam String transactionId) {
        return ResponseEntity.ok(transactionService.findByTransactionId(transactionId));
    }
}

