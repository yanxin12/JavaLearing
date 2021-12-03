// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 14:38
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework04;

public class test {
    public static void main(String[] args) {
        Waiter waiter = new Waiter(5000);
        Peasant peasant = new Peasant(6000);
        Worker worker = new Worker(7000);
        Farmer farmer = new Farmer(7000);
        Teacher teacher = new Teacher(6000, 25, 30);
        Scientist scientist = new Scientist(9000, 10000);
        System.out.println("服务员工资= " + waiter.salary + "   农民工资 =" +
                farmer.salary + "工人工资= " + worker.salary + "科学家工资 = " +
                scientist.salary + "教师工资 = " + teacher.salary);




    }
}
