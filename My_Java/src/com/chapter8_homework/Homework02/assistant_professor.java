// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 10:55
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework02;

public class assistant_professor extends teacher{
    public assistant_professor() {
    }

    public assistant_professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce(){



        System.out.println("Assistant Professor " + this.name + "is " + this.age +
                "years old, now is " + this.post + "and the salary is " +
                this.salary*1.2);
    }
}
