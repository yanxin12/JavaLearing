// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 14:36
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework04;

public class Scientist extends employee {
    double bonus;
    public Scientist(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
        this.salary = salary + bonus;
    }
}
