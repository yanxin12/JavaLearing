// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 20:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework03;

public class formatName {
    public void formatN(String str){
        int i = str.lastIndexOf(' ');
        while (i<str.length()){
            System.out.print(str.charAt(i++));
        }
        System.out.print(',');
        i = 0;
        while (str.charAt(i)!=' '){
            System.out.print(str.charAt(i++));
        }
        System.out.print(" ."+str.charAt(++i));

    }
}
