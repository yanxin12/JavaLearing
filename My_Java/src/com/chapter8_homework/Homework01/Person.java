// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-02 09:48
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework01;

public class Person {
    public String name;
    public int age;
    public String job;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    public void show(){
        System.out.println(this.name + "今年" + this.age + "岁了，" + "工作是" +this.job);
    }

}

class sort_P{
    public void Sort_P(Person [] arry){
        Person tmp = new Person();
        for (int i = arry.length-1; i > 0 ; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if(arry[j+1].age> arry[j].age){
                    tmp = arry[j+1];
                    arry[j+1] = arry[j];
                    arry[j] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0){
                break;
            }
        }

    }


}
