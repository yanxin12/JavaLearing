// -*- coding: utf-8 -*- 
/**
 * Project: AlgorithmsLearn
 * Creator: yanking
 * Create time: 2021-12-27 22:39
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.leetCode.purchasePlans;

import java.util.Arrays;

public class BigBulSolution_Two {
    public int purchasePlans(int[] nums, int target) {
        // 使用二分法+双指针
        int ans = 0;
        Arrays.sort(nums);
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            int l = left + 1, r = right;
            int temp = target - nums[left];
            while (l <= r) {
                // 二分查找temp值
                int mid = (l + r) >> 1;
                if (nums[mid] > temp) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            right = r;
            if (left < right) {
                ans = (ans + right - left) % (1000000007);
                //  不要最后进行取模运算
            }
        }
        return ans;
    }
}
