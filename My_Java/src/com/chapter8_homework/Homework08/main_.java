// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 11:00
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework08;

public class main_ {
    public static void main(String[] args) {
        Person student = new Student();//向上转型，可以调用Person的属性和方法，对于Student 类特有的属性和方法不能调用
        student.eat();
        student.run();
        ((Student) student) .study();//向下转型，实现student的特殊方法


    }
}
