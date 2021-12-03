// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 11:15
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework03;

public class main_ {
    public static void main(String[] args) {
        Manager manager = new Manager("小王",120,25);
        Worker worker = new Worker("小李", 100, 20);
        worker.print();
        manager.print();
    }
}
