package com.iholin.exceptions;

public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Сумма должна быть > 0, получено: " + amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств. Баланс: " + balance + ", запрос: " + amount, amount);
        }
        balance -= amount;
        System.out.println(name + ": списано " + amount + ". Баланс: " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Сумма должна быть > 0, получено: " + amount);
        }
        balance += amount;
        System.out.println(name + ": пополнено " + amount + ". Баланс: " + balance);
    }
}
