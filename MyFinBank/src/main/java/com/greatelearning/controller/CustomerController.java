package com.greatelearning.controller;


import com.greatelearning.entity.Customer;
import com.greatelearning.entity.Transaction;
import com.greatelearning.service.CustomerService;
import com.greatelearning.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/{id}/deposit")
    public Transaction deposit(@PathVariable Long id, @RequestParam Double amount) {
        Customer customer = customerService.findCustomerById(id);
        customerService.updateBalance(customer, amount);
        return transactionService.createTransaction(customer, amount, "DEPOSIT");
    }

    @PostMapping("/{id}/withdraw")
    public Transaction withdraw(@PathVariable Long id, @RequestParam Double amount) {
        Customer customer = customerService.findCustomerById(id);
        customerService.updateBalance(customer, -amount);
        return transactionService.createTransaction(customer, amount, "WITHDRAW");
    }
}
