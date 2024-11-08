package com.greatelearning.repository;


import com.greatelearning.entity.Customer;
import com.greatelearning.entity.Transaction;
import com.greatelearning.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}

public interface LoanRepository extends JpaRepository<Loan, Long> {}

