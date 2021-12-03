// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 10:58
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework08;

public class Student extends Person{
    @Override
    public void run() {
        System.out.println("I am a Student! I am running !");
    }
    public void study(){
        System.out.println("I am a Student! I am studying !");
    }

}
