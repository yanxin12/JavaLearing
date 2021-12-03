// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 11:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework03;

public class Manager extends employee {

    public Manager(String name, double daySalary, int workDay) {
        super(name, daySalary, workDay);
    }

    public void print(){
        System.out.println("Salary is " + (1000 + this.daySalary *workDay* 1.2));

    }
}
