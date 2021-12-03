// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework02;

public class teacher {
    public String name;
    public int age;
    public String post;
    public double salary;

    public teacher() {
    }

    public teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce(){
        System.out.println("Teacher " + this.name + "is " + this.age +
                "years old, now is " + this.post + "and the salary is " +
                this.salary);
    }


}
