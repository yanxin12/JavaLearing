// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 10:04
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework05;

import java.util.Scanner;

public class SavingsAccount extends CheckingAccount{
    public int freeTime = 0;
    public SavingsAccount(double banlance) {
        super(banlance);
    }

    public double earingMoneyInterest(double banlance) {
        System.out.println("Please input the interest Ratio!");
        Scanner myScanner = new Scanner(System.in);
        double ratio = myScanner.nextDouble();
        banlance = banlance * (1+ratio);
        freeTime = 3;
        return banlance;
    }
    public void deposit(double amount) {
        if(freeTime <=0)
            super.setBanlance(super.getBanlance() + amount - 1);
        else {
            super.setBanlance(super.getBanlance() + amount);
            freeTime--;
        }
    }

    public void withdraw(double amount) {
        if(freeTime <=0)
            super.setBanlance(super.getBanlance() - amount - 1);
        else{
            super.setBanlance(super.getBanlance() - amount );
            freeTime--;
        }

    }

}




