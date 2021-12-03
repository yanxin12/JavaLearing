// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 15:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework05;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(double banlance) {
        super(banlance);
    }

    public void deposit(double amount) {
        super.setBanlance(super.getBanlance() + amount - 1);
    }

    public void withdraw(double amount) {
        super.setBanlance(super.getBanlance() - amount - 1);
    }

}
