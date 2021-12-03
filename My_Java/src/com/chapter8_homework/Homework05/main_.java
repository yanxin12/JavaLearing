// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 10:23
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework05;

public class main_ {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(10000);
        savingsAccount.setBanlance(savingsAccount.earingMoneyInterest(savingsAccount.getBanlance()));
        savingsAccount.deposit(5000);
        savingsAccount.deposit(5000);
        savingsAccount.deposit(5000);
        savingsAccount.withdraw(5000);
        savingsAccount.withdraw(5000);
        savingsAccount.withdraw(5000);
        System.out.println(savingsAccount.getBanlance());
    }
}
