package com.iholin.exceptions;

public class InsufficientFundsException extends RuntimeException {
    private final double amount;

    public InsufficientFundsException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
