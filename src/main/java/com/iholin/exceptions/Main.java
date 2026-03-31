package com.iholin.exceptions;

public class Main {
    public static void main(String[] args) {
        BankAccount sberAccount = new BankAccount("Sber", 1000.0);
        BankAccount tAccount = new BankAccount("T-bank", -100.0);

        try {
            sberAccount.deposit(200.0);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            System.out.println("Операция депозита завершена!");
        }

        try {
            tAccount.deposit(200.0);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            System.out.println("Операция депозита завершена!");
        }

        try {
            sberAccount.withdraw(300.0);
        } catch (NegativeAmountException | InsufficientFundsException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            System.out.println("Операция отказа завершена!");
        }

        try {
            tAccount.withdraw(300.0);
        } catch (NegativeAmountException | InsufficientFundsException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            System.out.println("Операция отказа завершена!");
        }
    }
}
