// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 11:14
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework03;

public class Worker extends employee{
    public Worker(String name, double daySalary, int workDay) {
        super(name, daySalary, workDay);
    }

    public void print(){
        System.out.println("Salary is " + this.daySalary*this.workDay );

    }
}
