package com.greatelearning.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transaction;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String password;
    private Double balance;
    private Boolean isActive;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;

    // Getters and Setters
}

