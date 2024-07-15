package com.compulynx.interview.controller;

import com.compulynx.interview.model.Account;
import com.compulynx.interview.model.Customer;
import com.compulynx.interview.request.CustomerRegistrationRequest;
import com.compulynx.interview.service.AccountService;
import com.compulynx.interview.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;
    private final AccountService accountService;


    public CustomerController(CustomerService customerService, AccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerRegistrationRequest registrationRequest) {
        Customer customer = new Customer();
        customer.setName(registrationRequest.getName());
        customer.setEmail(registrationRequest.getEmail());
        customer.setCustomerId(registrationRequest.getCustomerId());
        customer.setPin(registrationRequest.getPin());

        // Call service layer to register customer
        Customer registeredCustomer = customerService.register(customer);
        Account account = accountService.createAccount(registeredCustomer);
        return ResponseEntity.ok(account);
    }
}
