// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-25 20:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.isPowerOfTwo;

public class BigBullResolution {
    public boolean isPowerOfTwo(int n) {
        return n > 1 && (n & (n - 1)) == 0;
    }
}
