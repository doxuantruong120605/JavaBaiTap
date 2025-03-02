package com.atmmini.atmminisize.service;

import com.atmmini.atmminisize.entity.Account;
import com.atmmini.atmminisize.entity.Transaction;
import com.atmmini.atmminisize.entity.TransactionType;
import com.atmmini.atmminisize.entity.User;
import com.atmmini.atmminisize.repository.AccountRepository;
import com.atmmini.atmminisize.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void deposit(String accountNumber, Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0");
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) throw new IllegalArgumentException("Không tìm thấy tài khoản");
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.DEPOSIT);
        transactionRepository.save(transaction);
    }

    @Transactional
    public void withdraw(String accountNumber, Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0");
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) throw new IllegalArgumentException("Không tìm thấy tài khoản");
        if (account.getBalance() < amount) throw new IllegalArgumentException("Số dư không đủ");
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.WITHDRAW);
        transactionRepository.save(transaction);
    }

    @Transactional
    public void transfer(String fromAccountNumber, String toAccountNumber, Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Số tiền chuyển phải lớn hơn 0");
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
        if (fromAccount == null || toAccount == null) throw new IllegalArgumentException("Tài khoản không hợp lệ");
        if (fromAccount.getBalance() < amount) throw new IllegalArgumentException("Số dư không đủ");

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction withdrawTx = new Transaction();
        withdrawTx.setAccount(fromAccount);
        withdrawTx.setAmount(amount);
        withdrawTx.setType(TransactionType.WITHDRAW);
        transactionRepository.save(withdrawTx);

        Transaction depositTx = new Transaction();
        depositTx.setAccount(toAccount);
        depositTx.setAmount(amount);
        depositTx.setType(TransactionType.DEPOSIT);
        transactionRepository.save(depositTx);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional
    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0.0);
        account.setUser(user);
        return accountRepository.save(account);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        return "ACC" + String.format("%010d", random.nextInt(1000000000));
    }
}