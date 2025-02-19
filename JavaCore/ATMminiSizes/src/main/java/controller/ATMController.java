package controller;

import model.ATMService;
import model.Account;

import java.util.List;

public class ATMController {
    private ATMService atmService;

    public ATMController() {
        atmService = new ATMService();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        atmService.createAccount(accountNumber, initialBalance);
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = atmService.getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = atmService.getAccount(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        return atmService.transfer(fromAccount, toAccount, amount);
    }

    public double checkBalance(String accountNumber) {
        Account account = atmService.getAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

    public List<String> getTransactionHistory(String accountNumber) {
        Account account = atmService.getAccount(accountNumber);
        if (account != null) {
            return account.getTransactionHistory();
        }
        return null;
    }
}