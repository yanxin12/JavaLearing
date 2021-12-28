// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-26 20:46
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findMin_;

public class findMin_ {
    // 给定一个旋转数组，判断是由原数组选择几次得到的
    public int findMin(int[] nums) {
        int minIndex = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        System.out.println("数组经过" + minIndex + "次旋转而来！");
        return min;
    }
}
