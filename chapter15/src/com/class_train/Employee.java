// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-27 20:28
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.class_train;

public class Employee {
    private String name;
    private  int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        super();
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + '\t' +
                "工资=" + sal +
                "生日=" + birthday +
                '\n';
    }
}
