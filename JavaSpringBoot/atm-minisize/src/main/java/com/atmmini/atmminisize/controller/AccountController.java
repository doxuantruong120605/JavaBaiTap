package com.atmmini.atmminisize.controller;

import com.atmmini.atmminisize.entity.Account;
import com.atmmini.atmminisize.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}")
    public String getAccount(@PathVariable String accountNumber, Model model) {
        Account account = accountService.getAccountByNumber(accountNumber);
        if (account == null) {
            model.addAttribute("error", "Không tìm thấy tài khoản");
            return "error";
        }
        model.addAttribute("account", account);
        return "account-details";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam Double amount, Model model) {
        try {
            accountService.deposit(accountNumber, amount);
            return "redirect:/account/" + accountNumber;
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam Double amount, Model model) {
        try {
            accountService.withdraw(accountNumber, amount);
            return "redirect:/account/" + accountNumber;
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String fromAccountNumber, @RequestParam String toAccountNumber,
                           @RequestParam Double amount, Model model) {
        try {
            accountService.transfer(fromAccountNumber, toAccountNumber, amount);
            return "redirect:/account/" + fromAccountNumber;
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}