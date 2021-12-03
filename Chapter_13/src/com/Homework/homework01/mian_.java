// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 19:41
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Homework.homework01;

import java.util.Scanner;

public class mian_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a String !");
        String arry = scanner.next();
        Reverse reverse = new Reverse();
        System.out.println("Input reversed string begin!");
        int a = scanner.nextInt();
        System.out.println("Input reversed string end!");
        int b = scanner.nextInt();
        reverse.reverse(arry, a, b);

    }
}

