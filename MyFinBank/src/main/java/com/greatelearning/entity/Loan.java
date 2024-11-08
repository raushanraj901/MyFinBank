package com.greatelearning.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double loanAmount;
    private Double interestRate;
    private Integer termMonths;
    private Boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Getters and Setters
}

