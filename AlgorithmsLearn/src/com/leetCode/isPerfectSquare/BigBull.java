// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-16 20:17
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isPerfectSquare;

public class BigBull {
    // 数学规律
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i = i + 2;
        }
        return num == 0;
    }
}
