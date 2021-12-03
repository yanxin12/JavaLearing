// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 10:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework02;
public class Professor extends teacher {


    public Professor() {
    }

    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce(){
        System.out.println("Professor " + this.name + "is " + this.age +
                "years old, now is " + this.post + "and the salary is " +
                this.salary*1.3);
    }




}
