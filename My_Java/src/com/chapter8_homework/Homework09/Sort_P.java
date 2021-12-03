// -*- coding: utf-8 -*- 
/**
 * Project: My_Java
 * Creator: yanking
 * Create time: 2021-08-03 11:29
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.chapter8_homework.Homework09;

public class Sort_P {
        public void Sort_P(Person[] arry){
            Person tmp = new Person();
            for (int i = arry.length-1; i > 0 ; i--) {
                int flag = 0;
                for (int j = 0; j < i; j++) {
                    if(arry[j+1].getAge()> arry[j].getAge()){
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
