package app;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");

        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Holder: ");
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();

        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.println();

        System.out.print("Enter amount for withdraw: ");
        double amountForWithdraw = sc.nextDouble();

        try {
            account.withdraw(amountForWithdraw);
            System.out.println("New balance: " + account.getBalance());
        } catch (BusinessException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        sc.close();
    }
}