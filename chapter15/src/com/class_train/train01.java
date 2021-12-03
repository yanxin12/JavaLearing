// -*- coding: utf-8 -*- 
/**
 * Project: chapter15
 * Creator: yanking
 * Create time: 2021-10-27 20:26
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.class_train;

import java.util.ArrayList;
import java.util.Comparator;

public class train01 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",8000,new MyDate(1999,4,8)));
        employees.add(new Employee("jack",8000,new MyDate(1998,4,8)));
        employees.add(new Employee("hsp",8000,new MyDate(1997,4,8)));
        employees.add(new Employee("hsp",18000,new MyDate(1997,5,8)));
        employees.add(new Employee("hsp",28000,new MyDate(1997,4,8)));
        employees.add(new Employee("lwj",8000,new MyDate(1999,4,8)));
        employees.add(new Employee("sq",18000,new MyDate(1998,5,8)));
        employees.add(new Employee("hx",28000,new MyDate(1996,6,8)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if ((e1.getName()).equals(e2.getName())) {
                    if ((e1.getBirthday()).getYear() != e2.getBirthday().getYear()){
                        return e1.getBirthday().getYear()-e2.getBirthday().getYear();
                    }else if ((e1.getBirthday()).getMonth() != e2.getBirthday().getMonth()){
                        return e1.getBirthday().getMonth()-e2.getBirthday().getMonth();
                    }else if ((e1.getBirthday()).getDay() != e2.getBirthday().getDay()){
                        return e1.getBirthday().getDay()-e2.getBirthday().getDay();
                    }else {
                        return 0;
                    }
                }else{
                    return (e1.getName()).compareTo((e2.getName()));
                }
            }

        });
        System.out.println(employees);
    }
}
