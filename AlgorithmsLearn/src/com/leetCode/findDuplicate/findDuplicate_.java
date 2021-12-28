// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 20:30
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.findDuplicate;

import java.util.Arrays;

public class findDuplicate_ {
    public int findDuplicate(int[] nums) {
        // 使用常量级的空间复杂度查找数组中的重复数字
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                temp = nums[i];
                break;
            }
        }
        return temp;
    }
}
