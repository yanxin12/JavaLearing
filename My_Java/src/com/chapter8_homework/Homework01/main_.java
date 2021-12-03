// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 09:53
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework01;

public class main_ {
    public static void main(String[] args) {
        Person person01 = new Person("小明", 19, "学生");
        Person person02 = new Person("小李", 20, "研究生");
        Person person03 = new Person("小杨", 29, "程序员");
        Person[] arry = new Person[3];
        arry[0]=person01;
        arry[1]=person02;
        arry[2]=person03;
        sort_P sp = new sort_P();
        sp.Sort_P(arry);
        arry[0].show();
        arry[1].show();
        arry[2].show();







    }
}
