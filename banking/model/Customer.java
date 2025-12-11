package com.banking.model;

public class Customer {
    private final int accountNumber;
    private final String name;
    private double balance;

    public Customer(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    // Setter (Only for balance, as ID and Name shouldn't change easily)
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account: %d | Name: %s | Balance: $%.2f", 
                             accountNumber, name, balance);
    }
}