// -*- coding: utf-8 -*- 

package com.Homework.homework01;

//实现字符串指定部分反转
//开发翻转方法，要求输入翻转字符串的起点和终点
public class Reverse {
    public void reverse(String arry, int a, int b) {
        if (a > b || a < 0 || b > arry.length()) {
            System.out.println("INPUT ERROR!!!");
            return;
        } else {
            StringBuilder res = new StringBuilder();
            int mid = (a + b) / 2;
            for (int i = 0; i < a; ++i) {
                res.append(arry.charAt(i));
            }
            for (int i = b; i > mid; --i) {
                res.append(arry.charAt(i));
            }
            for (int i = mid; i >= a; --i) {
                res.append(arry.charAt(i));
            }
            if (b < arry.length() - 1) {
                for (int i = b + 1; i < arry.length(); i++) {
                    res.append(arry.charAt(i));
                }
            }
            System.out.println("Original arry was " + arry);
            System.out.println("Reversed arry was " + res);
        }
    }
}

