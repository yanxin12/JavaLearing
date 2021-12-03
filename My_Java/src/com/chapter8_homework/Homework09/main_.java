// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 11:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework09;

public class main_ {
    public static void main(String[] args) {
        Person[] arry = new Person[4];
        arry[0] = new Student("小孔", "男", 21, "20170096");
        arry[1] = new Student("小王", "女", 18, "20200098");
        arry[2] = new Teacher("大王", "女", 38, 20);
        arry[3] = new Teacher("小李", "女", 48, 15);


        Sort_P sort_p = new Sort_P();
        sort_p.Sort_P(arry);

        for (int i = 0; i < arry.length ; ++i) {
            if(arry[i] instanceof  Student){
                System.out.println("学生的信息：");
                System.out.println("姓名：" + arry[i].getName() );
                System.out.println("年龄：" + arry[i].getAge() );
                System.out.println("性别：" + arry[i].getGender() );
                System.out.println("学号：" + ((Student) arry[i]).getStu_id());
                ((Student) arry[i]).study();
                ((Student) arry[i]).play();
            }
            if(arry[i] instanceof  Teacher){
                System.out.println("教师的信息：");
                System.out.println("姓名：" + arry[i].getName() );
                System.out.println("年龄：" + arry[i].getAge() );
                System.out.println("性别：" + arry[i].getGender() );
                System.out.println("教龄：" + ((Teacher) arry[i]).getWork_age());
                ((Teacher) arry[i]).teach();
                ((Teacher) arry[i]).play();
            }
        }
    }
}
