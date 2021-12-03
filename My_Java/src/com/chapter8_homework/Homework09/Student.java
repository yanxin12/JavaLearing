// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 11:10
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework09;

public class Student extends Person{

    private String stu_id;

    public Student(String name, String gender, int age, String stu_id) {
        super(name, gender, age);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

     void study(){
        System.out.println("我承诺，我会好好学习！");
    }

    String play(){
        return this.getName() + "爱玩足球！";
    }

}
