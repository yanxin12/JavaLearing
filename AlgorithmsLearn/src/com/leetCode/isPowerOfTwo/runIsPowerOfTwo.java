// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 20:33
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isPowerOfTwo;

public class runIsPowerOfTwo {
    public static void main(String[] args) {
        int n = 6;
        if (new BigBullResolution().isPowerOfTwo(n)) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }
    }
}
