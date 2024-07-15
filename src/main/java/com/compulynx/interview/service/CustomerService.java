package com.compulynx.interview.service;

import com.compulynx.interview.model.Customer;
import com.compulynx.interview.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer register(Customer customer) {
        customer.setPin(passwordEncoder.encode(customer.getPin())); // Encode the PIN before saving
        return customerRepository.save(customer);
    }

    public Customer findByCustomerId(String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
