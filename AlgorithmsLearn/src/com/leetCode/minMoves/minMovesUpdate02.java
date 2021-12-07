// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-07 11:01
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.minMoves;

public class minMovesUpdate02 {
    public static int minValues(int[] nums) {
        // 获取数组中最小值的方法
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
    // 谁用数学方法解决问题
    //  ans=∑i=0n−1(nums[i]−min⁡(nums))ans = \sum_{i=0}^{n-1}{(nums[i] - \min{(nums)}})ans=∑i=0n−1​(nums[i]−min(nums))
    public int minMoves(int[] nums) {
        int operationnum = 0;
        int min = minValues(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                operationnum+=nums[i]-min;
            }
        }
        return operationnum;
    }
}
