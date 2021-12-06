// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-05 23:37
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.MaxBytesLength;

public class MaxBytesLength {
    public int findMaxLength(int[] nums) {
        // 暴力破解
        int maxLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            int tempMax = 0;
            int zeroNum = 0;
            int oneNum = 0;
            for (int j = i; j < nums.length; ++j) {
                if (nums[j] == 0) {
                    ++zeroNum;
                } else {
                    ++oneNum;
                }
                // 忽略了连续
                // 011000011 最大连续相等子串为2
                tempMax = Math.min(oneNum, zeroNum);
                maxLength = Math.max(maxLength, tempMax);
            }
        }
        return maxLength;
    }
}


