package model;

import java.util.HashMap;
import java.util.Map;

public class ATMService {
    private Map<String, Account> accounts;

    public ATMService() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        Account from = accounts.get(fromAccount);
        Account to = accounts.get(toAccount);
        if (from != null && to != null && from.withdraw(amount)) {
            to.deposit(amount);
            from.addTransaction("Transferred: " + amount + " to " + toAccount);
            to.addTransaction("Received: " + amount + " from " + fromAccount);
            return true;
        }
        return false;
    }
}