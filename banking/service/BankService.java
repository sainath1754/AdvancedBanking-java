package com.banking.service;

import com.banking.model.Customer;
import java.util.HashMap;
import java.util.Map;

public class BankService
{
    // Simulating a database
    private final Map<Integer, Customer> repository = new HashMap<>();

    public BankService() 
    {
        // Seed initial data
        repository.put(123, new Customer(123, "Sainadh", 500.00));
        repository.put(234, new Customer(234, "Sridevi", 1000.00));
        repository.put(345, new Customer(345, "Suma", 1500.00));
    }

    public Customer authenticate(int accountNumber) throws Exception 
    {
        if (!repository.containsKey(accountNumber)) {
            throw new Exception("Authentication Failed: Account not found.");
        }
        return repository.get(accountNumber);
    }

    public void deposit(Customer customer, double amount) throws Exception
    {
        if (amount <= 0) throw new Exception("Invalid amount. Deposit must be positive.");
        customer.setBalance(customer.getBalance() + amount);
    }

    public void withdraw(Customer customer, double amount) throws Exception
    {
        if (amount <= 0) throw new Exception("Invalid amount.");
        if (customer.getBalance() < amount) 
        {
            throw new Exception("Insufficient Funds. Available: " + customer.getBalance());
        }
        customer.setBalance(customer.getBalance() - amount);
    }
}