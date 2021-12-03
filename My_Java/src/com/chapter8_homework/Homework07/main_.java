// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework07;

public class main_ {
    public static void main(String[] args) {
        Doctor doctor01 = new Doctor("小王",38,
                "doctor","男",                8000);
        Doctor doctor02 = new Doctor("小李",38,
                "doctor","男",                8000);
        if (doctor01.equals(doctor02)){
            System.out.println("相等！");
        }
        else{
            System.out.println("不相等！");
        }
    }


}
