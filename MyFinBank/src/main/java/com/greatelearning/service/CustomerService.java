package com.greatelearning.service;


import com.greatelearning.entity.Customer;
import com.greatelearning.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void updateBalance(Customer customer, Double amount) {
        customer.setBalance(customer.getBalance() + amount);
        customerRepository.save(customer);
    }
}
