// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 22:12
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.purchasePlans;

import java.util.Arrays;

public class BigBullSolution {
    // 使用大佬的三种解法
    // 1 双指针
    public int purchasePlans(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
//        for (int left = 0, right = nums.length - 1; left < right; left++) {
//            while (nums[left] + nums[right] > target) {
//                right--;
//            }
//            if (left < right) ans += right - left;
//        }
//        return ans % (1000000007);
//    }
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] > target) {
                --right;
            }
            if (left < right) {
                ans = (ans + right - left) % (1000000007);
            }
        }
        return ans;
    }
}
