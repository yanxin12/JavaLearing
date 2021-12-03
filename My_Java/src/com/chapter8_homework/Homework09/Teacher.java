// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 11:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework09;

public class Teacher extends Person{

    private int work_age;

    public Teacher(String name, String gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
   void teach(){
        System.out.println("我承诺，我会好好教学！");
    }
     String play(){
        return this.getName() + "爱玩象棋！";
    }

}
