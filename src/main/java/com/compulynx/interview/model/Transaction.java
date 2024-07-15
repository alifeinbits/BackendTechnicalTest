package com.compulynx.interview.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private Double amount;
    private String type; // DEPOSIT, WITHDRAWAL, TRANSFER

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
