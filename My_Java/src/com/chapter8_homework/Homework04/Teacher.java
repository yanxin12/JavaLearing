// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 14:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework04;

public class Teacher extends employee{
    double classDay;
    double classsal;

    public Teacher(double salary, double classDay, double classsal) {
        super(salary);
        this.classDay = classDay;
        this.classsal = classsal;
        this.salary = salary + classDay*classsal;
    }
}
