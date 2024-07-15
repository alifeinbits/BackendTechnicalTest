package com.compulynx.interview.request;


import lombok.Data;
import lombok.Getter;

@Data
public class TransactionRequest {
    private String accountId;
    private double amount;
    private String transactionType;


}

