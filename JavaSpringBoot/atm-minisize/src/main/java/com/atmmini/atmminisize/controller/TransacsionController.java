package com.atmmini.atmminisize.controller;

import com.atmmini.atmminisize.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransacsionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{accountId}")
    public String getTransactions(@PathVariable Long accountId, Model model) {
        try {
            // Lấy danh sách giao dịch dựa trên accountId
            model.addAttribute("transactions", transactionService.getTransactionsByAccountId(accountId));
            return "transaction-list"; // Trả về template transaction-list.html
        } catch (Exception e) {
            model.addAttribute("error", "Không tìm thấy lịch sử giao dịch cho tài khoản với ID: " + accountId);
            return "error"; // Trả về trang lỗi tùy chỉnh
        }
    }
}
