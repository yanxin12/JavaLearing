// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 14:57
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework05;

public class BankAccount {
    private double banlance;

    public BankAccount(double banlance) {
        this.banlance = banlance;
    }
    public void deposit(double amount){
        banlance += amount;
    }
    public  void withdraw(double amount){
        banlance -= amount;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }
}
