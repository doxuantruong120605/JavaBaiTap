package view;

import controller.ATMController;

import java.util.List;
import java.util.Scanner;

public class ATMConsole {
    private ATMController controller;
    private Scanner scanner;

    public ATMConsole() {
        controller = new ATMController();
        scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }

            switch (choice) {
                case 1:
                    createAccountView();
                    break;
                case 2:
                    depositView();
                    break;
                case 3:
                    withdrawView();
                    break;
                case 4:
                    transferView();
                    break;
                case 5:
                    checkBalanceView();
                    break;
                case 6:
                    transactionHistoryView();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void createAccountView() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());
        controller.createAccount(accountNumber, initialBalance);
        System.out.println("Account created successfully.");
    }

    private void depositView() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (controller.deposit(accountNumber, amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Account not found.");
        }
    }

    private void withdrawView() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (controller.withdraw(accountNumber, amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or account not found.");
        }
    }

    private void transferView() {
        System.out.print("Enter from account number: ");
        String fromAccount = scanner.nextLine();
        System.out.print("Enter to account number: ");
        String toAccount = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (controller.transfer(fromAccount, toAccount, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check account numbers and balance.");
        }
    }

    private void checkBalanceView() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        double balance = controller.checkBalance(accountNumber);
        if (balance >= 0) {
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void transactionHistoryView() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        List<String> history = controller.getTransactionHistory(accountNumber);
        if (history != null) {
            System.out.println("Transaction History:");
            for (String transaction : history) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }


}